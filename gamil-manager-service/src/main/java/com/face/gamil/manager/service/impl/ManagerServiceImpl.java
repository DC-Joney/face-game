package com.face.gamil.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.face.gamil.bean.manage.BaseAttrInfo;
import com.face.gamil.bean.manage.BaseAttrValue;
import com.face.gamil.bean.manage.BaseCatalog;
import com.face.gamil.manager.mapper.BaseAttrInfoMapper;
import com.face.gamil.manager.mapper.BaseAttrValueMapper;
import com.face.gamil.manager.mapper.BaseCatalogMapper;
import com.face.gamil.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private BaseCatalogMapper catalogMapper;

    @Autowired
    private BaseAttrInfoMapper attrInfoMapper;

    @Autowired
    private BaseAttrValueMapper attrValueDao;

    @Override
    public List<BaseCatalog> getCatalog() {

        Example condition = Example.builder(BaseCatalog.class).setTableName("base_catalog1")
                .andWhere(Sqls.custom().andIsNull("parentId")).build();

        return catalogMapper.selectByExample(condition);
    }

    @Override
    public List<BaseCatalog> getCatalogByParentId(String tableName, String parentId) {

        Example build = Example.builder(BaseCatalog.class).setTableName(tableName)
                .andWhere(Sqls.custom().andEqualTo("parentId", parentId)).build();

        return catalogMapper.selectByExample(build);
    }

    @Override
    public List<BaseAttrInfo> getAttrList(String catalogId) {
        return attrInfoMapper.selectById(catalogId);
    }

    @Override
    public void saveBaseAttrInfo(BaseAttrInfo baseAttrInfo) {
        try {
            baseAttrInfo.setId(null);
            System.out.println("来了 ...");
            attrInfoMapper.insertSelective(baseAttrInfo);

            System.out.println(baseAttrInfo);

            System.out.println(baseAttrInfo.getAttrInfo());

            if(baseAttrInfo.getAttrInfo() != null && baseAttrInfo.getAttrInfo().size() > 0){
                attrValueDao.insertCollectionSelective(baseAttrInfo.getAttrInfo());
            }



//            Optional.ofNullable(baseAttrInfo.getAttrInfo())
//                    .orElseGet(Collections::emptyList)
//                    .forEach(attrValue ->{
//                        attrValue.setId(null);
//                        attrValue.setAttrId(baseAttrInfo.getId());
//                        attrValueDao.insert(attrValue);
//                    });
        }catch (Exception e){
            //包装业务异常
            throw e;
       }
    }


    @PostConstruct
    public void test(){

        BaseAttrInfo baseAttrInfo = new BaseAttrInfo(null,"测试","17",null);

        saveBaseAttrInfo(baseAttrInfo);

        System.out.println(baseAttrInfo);

        List<BaseAttrValue> baseAttrValues = new ArrayList<>();

        baseAttrValues.add(new BaseAttrValue(null,"测试1","3"));
        baseAttrValues.add(new BaseAttrValue(null,"测试2","4"));
        baseAttrValues.add(new BaseAttrValue(null,"测试3","5"));

        System.out.println(attrValueDao.insertCollectionSelective(baseAttrValues));
    }




}
