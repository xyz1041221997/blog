package cn.xyz.blog.service;

import cn.xyz.blog.dao.TypeDao;
import cn.xyz.blog.entity.Type;
import cn.xyz.blog.serviceImp.TypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;

public class TypeService implements TypeServiceImp {
    @Autowired
    TypeDao typeDao;
    @Override
    public void createType(Type type) {
        typeDao.save(type);
    }

    @Override
    public void deleteType(Long id) {
        typeDao.deleteTypeById(id);
    }
}
