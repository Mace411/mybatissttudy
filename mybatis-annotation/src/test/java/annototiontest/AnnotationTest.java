package annototiontest;

import com.mace.mapper.UserMapper;
import com.mace.pojo.User;
import com.mace.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class AnnotationTest {

    @Test
    public void testAnnoGetUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.err.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testAnnoGetUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.err.println(userById);

        sqlSession.close();
    }
}
