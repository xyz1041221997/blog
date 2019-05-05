package cn.xyz.blog.serviceImp;

import cn.xyz.blog.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageServiceImp {
    /**
     * 查询所有留言
     * @return
     */
    Page<Message> findAllMessage(Pageable page);

    /**
     * 增加一条留言
     */
    void createMessage(Message message);

    /**
     * 删除一条留言
     * @param id
     */
    void deleteMessage(Long id);

    void updateMessage(Message message);
}
