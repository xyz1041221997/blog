package cn.xyz.blog.service;

import cn.xyz.blog.dao.DiaryDao;
import cn.xyz.blog.entity.Diary;
import cn.xyz.blog.serviceImp.DiaryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DiaryService implements DiaryServiceImp {

    @Autowired
    DiaryDao diaryDao;

    @Override
    public void createDiary(Diary diary) {
        diaryDao.save(diary);
    }

    /**
     * 事务回滚
     * @param diary
     * @return
     */
    @Transactional(rollbackOn = Exception.class)
    @Override
    public boolean updateDiary(Diary diary) {
        diaryDao.updateDiary(diary.getContent(),diary.getId());
        return true;
    }

    @Override
    public boolean deletaDiary(Long id) {
        diaryDao.deleteById(id);
        return false;
    }

    @Override
    public Page<Diary> findAllDiary(Pageable page) {
        return  diaryDao.findAll(page);
    }
}
