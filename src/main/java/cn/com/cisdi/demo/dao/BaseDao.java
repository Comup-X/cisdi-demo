package cn.com.cisdi.demo.dao;


import cn.com.cisdi.demo._base.Page;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MapReduceIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Comup
 */
public abstract class BaseDao {
    private static final Logger logger = LoggerFactory.getLogger(BaseDao.class);

    private static final ConcurrentHashMap<Class, BaseDao> DAOS = new ConcurrentHashMap<>();

    private static final MongoClient MONGO_CLIENT = new MongoClient("192.168.100.1");

    private static final MongoDatabase MONGO_DATABASE = MONGO_CLIENT.getDatabase("cisdi-demo");

    BaseDao() {
        DAOS.put(this.getClass(), this);
    }

    /**
     * 获取需要的Dao
     *
     * @param requiredType 需要的Dao类型
     * @return 需要的Dao
     */
    public static <T extends BaseDao> T getDao(Class<T> requiredType) {
        if (DAOS.containsKey(requiredType)) {
            return (T) DAOS.get(requiredType);
        }
        try {
            Constructor c0 = requiredType.getDeclaredConstructor();
            c0.setAccessible(true);
            T need = (T) c0.newInstance();
            DAOS.put(requiredType, need);
            return need;
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            logger.error("Init Dao error", e);
            throw new RuntimeException("Init Dao error");
        }
    }

    /**
     * 获取MongoClient
     *
     * @return MongoClient
     */
    public static MongoClient getClient() {
        return MONGO_CLIENT;
    }

    /**
     * 获取对应的Dao集合
     *
     * @return 集合
     */
    public MongoCollection<Document> getCollection() {
        return MONGO_DATABASE.getCollection(getCollectionName());
    }

    /**
     * 此抽象类方法将使用此名字操作集合
     *
     * @return 继承的Dao所操作的集合的名字
     */
    protected abstract String getCollectionName();

    /**
     * 计算平均数
     *
     * @param field 需要计算的列名
     * @return 平均数
     */
    public double avg(String field) {
        BasicDBObject group = new BasicDBObject("$group", new BasicDBObject("_id", null).append("avg", new BasicDBObject("$avg", "$" + field)));
        AggregateIterable<Document> aggregate = MONGO_DATABASE.getCollection("data").aggregate(Collections.singletonList(group));
        if (aggregate.iterator().hasNext()) {
            return Double.valueOf(aggregate.iterator().next().get("avg").toString());
        }
        return 0D;
    }

    /**
     * 计算字符串因子数
     *
     * @param field 需要计算的列名
     * @return 所有因子数
     */
    public List<String> factor(String field) {
        List<String> result = new ArrayList<>();
        getCollection().distinct(field,String.class).iterator().forEachRemaining(result::add);
        return result;
    }

    /**
     * 计算标准差
     *
     * @param field 需要计算的列名
     * @return 此列标准差
     */
    public double std(String field) {
        String map = "function(){emit(null,this." + field + ");}";
        String reduce = "function(key,values){return Standard_Deviation(key,values)}";
        MapReduceIterable<Document> mapReduce = getCollection().mapReduce(map, reduce);
        if (mapReduce.iterator().hasNext()) {
            return Double.valueOf(mapReduce.iterator().next().get("value").toString());
        }
        return 0D;
    }

    /**
     * 计算离群值个数
     *
     * @param field 需要计算的列名
     * @return 离群值个数
     */
    public long ns(String field) {
        double avg = avg(field);
        double std = std(field);
        double top = avg + (3 * std);
        double bottom = avg - (3 * std);
        BasicDBObject lt = new BasicDBObject(field, new BasicDBObject("$lt", bottom));
        BasicDBObject gt = new BasicDBObject(field, new BasicDBObject("$gt", top));
        BasicDBObject or = new BasicDBObject("$or", new BasicDBObject[]{lt, gt});
        return getCollection().count(or);
    }

    /**
     * 保存对象到集合
     *
     * @param document 需要保存的对象
     */
    public void save(Document document) {
        getCollection().insertOne(document);
    }

    /**
     * 保存对象到集合
     *
     * @param document 需要保存的对象
     */
    public void save(List<Document> document) {
        getCollection().insertMany(document);
    }

    /**
     * 分页查询
     *
     * @param page 第几页
     * @param size 每页大小
     * @return 分页查询结果
     */
    public Page<Document> findAll(int page, int size) {
        if (page <= 0) {
            throw new IllegalArgumentException("Page Must gt 0");
        }
        if (size <= 0) {
            throw new IllegalArgumentException("Size Must gt 0");
        }
        long count = getCollection().count();
        Page<Document> result = new Page<>();
        result.setContent(new ArrayList<>());
        if (count == 0) {
            result.setTotalPages(0);
        } else {
            result.setTotalPages(Double.valueOf(Math.ceil(count / (double) size)).intValue());
        }
        getCollection().find().skip((page - 1) * size).limit(size).iterator().forEachRemaining(document -> result.getContent().add(document));
        return result;
    }
}