import com.app.mapper.UserMapper;
import com.app.pojo.User;
import com.app.pojo.UserExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by heqiyan on 2016/12/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:config/spring/*.xml"})
public class TestPageHelper {

    @Resource
    private UserMapper usermMapper;

    @Test
    public void testPageHelper() throws Exception {
        //2、设置分页,第104页，每页显示30条
        PageHelper.startPage(2, 3);
        //3、执行查询
        UserExample ue = new UserExample();
        List<User> list = usermMapper.selectByExample(ue);
        for(User u: list) {
            System.out.println(u.getEmail());
        }

        //4、取分页后结果
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        int pageNum = pageInfo.getPageNum();
        System.out.println("当前是第几页:" + pageNum);
        int pageSize = pageInfo.getPageSize();
        System.out.println("当前页最多显示几条:" + pageSize);
        int size = pageInfo.getSize();
        System.out.println("当前页有几条记录:" + size);
        int startRow = pageInfo.getStartRow();
        System.out.println("当前页开始记录:" + startRow);
        int endRow = pageInfo.getEndRow();
        System.out.println("当前页最后一条记录:" + endRow);
        long total = pageInfo.getTotal();
        System.out.println("总共查出来多少条记录:" + total);
        int pages = pageInfo.getPages();
        System.out.println("总共有多少页:" + pages);
    }
}
