package cn.xyz.blog.serviceImp;

import cn.xyz.blog.entity.Diary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DiaryServiceImp {

    /**
     * 创建日记
     * @param diary
     */
    void createDiary(Diary diary);

    /**
     * 修改日记
     * @param diary
     * @return
     */
    boolean updateDiary(Diary diary);

    /**
     * 删除日记
     * @param id
     * @return
     */
    boolean deletaDiary(Long id);

    /**
     * 分页查询所有日记
     * @param var1
     * @return
     */
    Page<Diary> findAllDiary(Pageable var1);
}
