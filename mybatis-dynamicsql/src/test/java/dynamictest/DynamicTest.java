package dynamictest;

import com.mace.mapper.UserMapper;
import com.mace.pojo.User;
import com.mace.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicTest {

    @Test
    public void testGetUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.err.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.insertUser(new User(2, "法外狂徒张三", "女", 19, "zhangsan"));
        System.err.println(i);
        sqlSession.close();
    }

    @Test
    public void testGetUserListByCondition() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
//        map.put("age", 19);
        map.put("name", "张三");
        List<User> userList = mapper.getUserListByCondition(map);
        for (User user : userList) {
            System.err.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testUpdateUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("age", 29);
        map.put("name", "法外狂徒张三");
        map.put("new_name", "张三");
        mapper.updateUser(map);
        sqlSession.close();

//        List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
//        BlockingQueue queue = new ArrayBlockingQueue(10);
//        PriorityQueue queue1 = new PriorityQueue();
//        Queue<Integer> queue2 = new LinkedList<Integer>();
//        queue.put();
//        Object take = queue.take();
    }

}
