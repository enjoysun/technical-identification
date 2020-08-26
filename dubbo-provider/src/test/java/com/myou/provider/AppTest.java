package com.myou.provider;

import static org.junit.Assert.assertTrue;

import com.alibaba.dubbo.config.annotation.Reference;
import com.myou.provider.ProviderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import service.FooService;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Reference
    private FooService fooService;
    @Test
    public void shouldAnswerWithTrue()
    {
        String key = fooService.foo("pipi");
        assertTrue( true );
    }
}
