package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Persistence.mapper.SearchMapper;
import com.example.demo.Persistence.model.SearchEntity;
import com.example.demo.Service.Interface.ISearchService;
import com.example.demo.help.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/*@Service
@Transactional
public class SearchService extends ServiceImpl<SearchMapper, Object> implements ISearchService {
    private static final Map<String,String> deviceName2TableName;
    static{
        deviceName2TableName = new HashMap<>();
        deviceName2TableName.put("火焰切割机1","S01");
        deviceName2TableName.put("火焰切割机2","S02");
        deviceName2TableName.put("火焰切割机3","S03");
        deviceName2TableName.put("上料工位","S04");
        deviceName2TableName.put("H型钢组立工位","S05");
        deviceName2TableName.put("进料缓存工位","S06");
        deviceName2TableName.put("龙门气保焊专机1","S07");
        deviceName2TableName.put("环链式翻转机1","S08");
        deviceName2TableName.put("龙门气保焊专机2","S09");
        deviceName2TableName.put("龙门埋弧焊专机1","S10");
        deviceName2TableName.put("环链式翻转机2","S11");
        deviceName2TableName.put("龙门埋弧焊专机2","S12");
        deviceName2TableName.put("出料缓存工位","S13");
        deviceName2TableName.put("卧式矫正机","S14");
        deviceName2TableName.put("数控型钢钻孔机","S15");
        deviceName2TableName.put("机器人型钢切割机","S16");
        deviceName2TableName.put("抛丸线","S17");
        deviceName2TableName.put("喷涂烘干设备","S18");
        deviceName2TableName.put("","S19");
        deviceName2TableName.put("等离子激光切割机","S20");
        deviceName2TableName.put("龙门激光切割机","S21");
    }

    @Resource
    private SearchMapper searchMapper;

    @Override
    public Response<Object> queryData(SearchEntity searchData) {
        //工位名称转查询数据表格名称
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,cal.get(Calendar.HOUR_OF_DAY)-1);
        searchData.setDeviceName(deviceName2TableName.get(searchData.getDeviceName()));
        Date Now = new Date();
        if(searchData.getStartTime()==null){//默认查询一个小时的数据
            searchData.setStartTime(cal.getTime());
        }
        if(searchData.getEndTime()==null){
            searchData.setEndTime(Now);
        }
        List<Object> result = searchMapper.search(searchData);
        return new Response<>(result);
    }
}*/
