package cn.com.cisdi.demo.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Comup
 */
public class DataDao extends BaseDao {

    private static final Logger logger = LoggerFactory.getLogger(DataDao.class);

    private static final String COLLECTION_NAME = "data";

    /**
     * 私有构造器请通过BaseDao静态方法获取此类实例，请不要通过反射创建此类对象
     */
    private DataDao() {
    }

    @Override
    protected String getCollectionName() {
        return COLLECTION_NAME;
    }

    /**
     * 测试结果
     * 【A1列平均值:-5.952329658238002】【A1列标准差:3.5587527220515502】【A1列离群值个数:0】【计算耗时：1112毫秒】
     * 【A2列平均值:87.20752410482977】【A2列标准差:31.4572064716055】【A2列离群值个数:0】【计算耗时：1006毫秒】
     * 【A3列平均值:1702.7124303953142】【A3列标准差:661.7715760379429】【A3列离群值个数:0】【计算耗时：1031毫秒】
     * 【A4列平均值:-34.33242357816622】【A4列标准差:21.020854345431758】【A4列离群值个数:0】【计算耗时：1170毫秒】
     * 【A5列平均值:1.1098346976334126】【A5列标准差:0.5098686406710785】【A5列离群值个数:0】【计算耗时：1027毫秒】
     * 【A6列平均值:157.48089265943037】【A6列标准差:71.59457505619145】【A6列离群值个数:0】【计算耗时：994毫秒】
     * 【A7列平均值:-0.7163869778521863】【A7列标准差:0.4059356192046178】【A7列离群值个数:0】【计算耗时：1037毫秒】
     * 【A8列平均值:-0.5733533040998866】【A8列标准差:0.32431910321738716】【A8列离群值个数:0】【计算耗时：1041毫秒】
     * 【A9列平均值:830.610954875232】【A9列标准差:284.73144581127013】【A9列离群值个数:0】【计算耗时：1231毫秒】
     * 【A10列平均值:26103.206292336337】【A10列标准差:8297.74960280113】【A10列离群值个数:0】【计算耗时：1028毫秒】
     * 【A11列平均值:1232.093613674813】【A11列标准差:484.402169371863】【A11列离群值个数:0】【计算耗时：1084毫秒】
     * 【A12列平均值:1533.7558763382551】【A12列标准差:597.6202755262144】【A12列离群值个数:0】【计算耗时：1093毫秒】
     * 【Quality列因子数:[bad, ok]】【计算耗时：46毫秒】
     * 【测试共计耗时：12902毫秒】
     */
    public static void main(String[] args) {
        DataDao dao = BaseDao.getDao(DataDao.class);
        long startTime;
        long endTime;
        long testBeginTime = System.currentTimeMillis();
        double avg;
        double std;
        long ns;
        List<String> factor;
        //A1列
        startTime = System.currentTimeMillis();
        avg = dao.avg("A1");
        std = dao.std("A1");
        ns = dao.ns("A1");
        endTime = System.currentTimeMillis();
        logger.info(System.lineSeparator() + "【A1列平均值:{}】【A1列标准差:{}】【A1列离群值个数:{}】【计算耗时：{}毫秒】", avg, std, ns, endTime - startTime);
        //A2列
        startTime = System.currentTimeMillis();
        avg = dao.avg("A2");
        std = dao.std("A2");
        ns = dao.ns("A2");
        endTime = System.currentTimeMillis();
        logger.info(System.lineSeparator() + "【A2列平均值:{}】【A2列标准差:{}】【A2列离群值个数:{}】【计算耗时：{}毫秒】", avg, std, ns, endTime - startTime);
        //A3列
        startTime = System.currentTimeMillis();
        avg = dao.avg("A3");
        std = dao.std("A3");
        ns = dao.ns("A3");
        endTime = System.currentTimeMillis();
        logger.info(System.lineSeparator() + "【A3列平均值:{}】【A3列标准差:{}】【A3列离群值个数:{}】【计算耗时：{}毫秒】", avg, std, ns, endTime - startTime);
        //A4列
        startTime = System.currentTimeMillis();
        avg = dao.avg("A4");
        std = dao.std("A4");
        ns = dao.ns("A4");
        endTime = System.currentTimeMillis();
        logger.info(System.lineSeparator() + "【A4列平均值:{}】【A4列标准差:{}】【A4列离群值个数:{}】【计算耗时：{}毫秒】", avg, std, ns, endTime - startTime);
        //A5列
        startTime = System.currentTimeMillis();
        avg = dao.avg("A5");
        std = dao.std("A5");
        ns = dao.ns("A5");
        endTime = System.currentTimeMillis();
        logger.info(System.lineSeparator() + "【A5列平均值:{}】【A5列标准差:{}】【A5列离群值个数:{}】【计算耗时：{}毫秒】", avg, std, ns, endTime - startTime);
        //A6列
        startTime = System.currentTimeMillis();
        avg = dao.avg("A6");
        std = dao.std("A6");
        ns = dao.ns("A6");
        endTime = System.currentTimeMillis();
        logger.info(System.lineSeparator() + "【A6列平均值:{}】【A6列标准差:{}】【A6列离群值个数:{}】【计算耗时：{}毫秒】", avg, std, ns, endTime - startTime);
        //A7列
        startTime = System.currentTimeMillis();
        avg = dao.avg("A7");
        std = dao.std("A7");
        ns = dao.ns("A7");
        endTime = System.currentTimeMillis();
        logger.info(System.lineSeparator() + "【A7列平均值:{}】【A7列标准差:{}】【A7列离群值个数:{}】【计算耗时：{}毫秒】", avg, std, ns, endTime - startTime);
        //A8列
        startTime = System.currentTimeMillis();
        avg = dao.avg("A8");
        std = dao.std("A8");
        ns = dao.ns("A8");
        endTime = System.currentTimeMillis();
        logger.info(System.lineSeparator() + "【A8列平均值:{}】【A8列标准差:{}】【A8列离群值个数:{}】【计算耗时：{}毫秒】", avg, std, ns, endTime - startTime);
        //A9列
        startTime = System.currentTimeMillis();
        avg = dao.avg("A9");
        std = dao.std("A9");
        ns = dao.ns("A9");
        endTime = System.currentTimeMillis();
        logger.info(System.lineSeparator() + "【A9列平均值:{}】【A9列标准差:{}】【A9列离群值个数:{}】【计算耗时：{}毫秒】", avg, std, ns, endTime - startTime);
        //A10列
        startTime = System.currentTimeMillis();
        avg = dao.avg("A10");
        std = dao.std("A10");
        ns = dao.ns("A10");
        endTime = System.currentTimeMillis();
        logger.info(System.lineSeparator() + "【A10列平均值:{}】【A10列标准差:{}】【A10列离群值个数:{}】【计算耗时：{}毫秒】", avg, std, ns, endTime - startTime);
        //A11列
        startTime = System.currentTimeMillis();
        avg = dao.avg("A11");
        std = dao.std("A11");
        ns = dao.ns("A11");
        endTime = System.currentTimeMillis();
        logger.info(System.lineSeparator() + "【A11列平均值:{}】【A11列标准差:{}】【A11列离群值个数:{}】【计算耗时：{}毫秒】", avg, std, ns, endTime - startTime);
        //A12列
        startTime = System.currentTimeMillis();
        avg = dao.avg("A12");
        std = dao.std("A12");
        ns = dao.ns("A12");
        endTime = System.currentTimeMillis();
        logger.info(System.lineSeparator() + "【A12列平均值:{}】【A12列标准差:{}】【A12列离群值个数:{}】【计算耗时：{}毫秒】", avg, std, ns, endTime - startTime);
        //Quality列
        startTime = System.currentTimeMillis();
        factor = dao.factor("Quality");
        endTime = System.currentTimeMillis();
        logger.info(System.lineSeparator() + "【Quality列因子数:{}】【计算耗时：{}毫秒】", factor, endTime - startTime);
        long testEndTime = System.currentTimeMillis();
        logger.info(System.lineSeparator() + "【测试共计耗时：{}毫秒】", testEndTime - testBeginTime);
    }
}



























