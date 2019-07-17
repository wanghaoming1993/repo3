package com.itcast.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.ssm.dao.IProductDao;
import com.itcast.ssm.domain.Product;
import com.itcast.ssm.service.IProdcutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements IProdcutService {
    @Autowired
    private IProductDao productDao;


    /**
     * 查询所有产品
     * @return
     */
    @Override
    public List<Product> findAllProduct(Integer page,Integer pageSize)throws Exception {
        PageHelper.startPage(page,pageSize);
        return productDao.findAllProduct();
    }


    public void save(Product product){
        productDao.save(product);
    }
}
