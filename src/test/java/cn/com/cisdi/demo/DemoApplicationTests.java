package cn.com.cisdi.demo;

import cn.com.cisdi.demo._base.Page;
import cn.com.cisdi.demo.controller.FileController;
import cn.com.cisdi.demo.dao.BaseDao;
import cn.com.cisdi.demo.dao.DataDao;
import org.bson.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private FileController fileController;

    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void avgTest() {
        DataDao dao = BaseDao.getDao(DataDao.class);
        Assert.assertEquals(-5.952329658238002D, dao.avg("A1"), 0);
    }

    @Test
    public void nsTest() {
        DataDao dao = BaseDao.getDao(DataDao.class);
        Assert.assertEquals(0, dao.ns("A1"), 0);
    }

    @Test
    public void stdTest() {
        DataDao dao = BaseDao.getDao(DataDao.class);
        Assert.assertEquals(3.5587527220515502D, dao.std("A1"), 0);
    }

    @Test
    public void factorTest() {
        DataDao dao = BaseDao.getDao(DataDao.class);
        List<String> factor = dao.factor("Quality");
        String[] expect = new String[]{"bad", "ok"};
        String[] strings = factor.toArray(new String[]{});
        Assert.assertArrayEquals(expect, strings);
    }

    @Test
    public void findTest() {
        DataDao dao = BaseDao.getDao(DataDao.class);
        Page<Document> page = dao.findAll(1, 10);
        Assert.assertEquals(10, page.getContent().size());
        Assert.assertEquals(3001, page.getTotalPages());
    }

    @Test
    public void saveTest() {
        DataDao dao = BaseDao.getDao(DataDao.class);
        Document document = new Document();
        document.put("A1", 1);
        document.put("A2", 1);
        document.put("A3", 1);
        document.put("A4", 1);
        document.put("A5", 1);
        document.put("A6", 1);
        document.put("A7", 1);
        document.put("A8", 1);
        document.put("A9", 1);
        document.put("A10", 1);
        document.put("A11", 1);
        document.put("A12", 1);
        document.put("Quality", "bad");
        dao.save(document);
    }

    @Test
    public void setCSVFieldTest() throws IOException, InterruptedException {
        Runnable runnable = () -> {
            try {
                fileController.setCSVField("1578a4de-7c68-43cf-9beb-f9149466e929.csv", 2, 1, String.valueOf(Math.random()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        Thread thread5 = new Thread(runnable);
        Thread thread6 = new Thread(runnable);
        Thread thread7 = new Thread(runnable);
        Thread thread8 = new Thread(runnable);
        Thread thread9 = new Thread(runnable);
        Thread thread10 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        thread7.join();
        thread8.join();
        thread9.join();
        thread10.join();
    }

    @Test
    public void delCSVRowTest() throws IOException, InterruptedException {
        Runnable runnable = () -> {
            try {
                fileController.delCSVRow("1578a4de-7c68-43cf-9beb-f9149466e929.csv", 2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        Thread thread5 = new Thread(runnable);
        Thread thread6 = new Thread(runnable);
        Thread thread7 = new Thread(runnable);
        Thread thread8 = new Thread(runnable);
        Thread thread9 = new Thread(runnable);
        Thread thread10 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        thread7.join();
        thread8.join();
        thread9.join();
        thread10.join();
    }

    @Test
    public void delCSVColumnTest() throws IOException, InterruptedException {
        Runnable runnable = () -> {
            try {
                fileController.delCSVColumn("1578a4de-7c68-43cf-9beb-f9149466e929.csv", 2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        Thread thread5 = new Thread(runnable);
        Thread thread6 = new Thread(runnable);
        Thread thread7 = new Thread(runnable);
        Thread thread8 = new Thread(runnable);
        Thread thread9 = new Thread(runnable);
        Thread thread10 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        thread7.join();
        thread8.join();
        thread9.join();
        thread10.join();
    }

    @Test
    public void downloadTest() throws Exception {
        mockMvc.perform(
                get("/file/download").param("fileName", "1578a4de-7c68-43cf-9beb-f9149466e929.csv"))
                .andExpect(status().isOk());
    }
}
