package cn.xyz.blog.service;

import cn.xyz.blog.dao.MessageDao;
import cn.xyz.blog.entity.Message;
import cn.xyz.blog.serviceImp.MessageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements MessageServiceImp {
    @Autowired
    MessageDao messageDao;

    /**
     * 分页查询所有留言实现
     * @param page
     * @return
     */
    @Override
    public Page<Message> findAllMessage(Pageable page) {
       return messageDao.findAll(page);
    }

    @Override
    public void createMessage(Message message) {
        messageDao.save(message);
    }

    @Override
    public void deleteMessage(Long id) {

    }

    @Override
    public void updateMessage(Message message) {

    }
}
