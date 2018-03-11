package com;

import com.model.Shop;
import com.repository.ShopRepositories;
import com.service.ShopService;
import com.service.ShopServiceImpl;
import org.junit.After;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

/**
 * Created by khan on 14/12/16.
 */

public class ShopServiceImplTest {
    @InjectMocks
    ShopServiceImpl shopServiceImpl;
    @Mock
    ShopRepositories shopRepositories;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        Mockito.verifyNoMoreInteractions(shopRepositories);
    }
}
