package cn.xyz.blog.dao;

import cn.xyz.blog.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDao extends JpaRepository<Message,Long> {



}
