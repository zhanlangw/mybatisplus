package com.mybatis.plus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.plus.user.entity.User;
import com.mybatis.plus.user.mapper.UserMapper;
import com.mybatis.plus.user.service.IUserService;
import com.mybatis.plus.user.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PlusApplicationTes {

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private UserMapper mapper;
	@Test
	public void save() {
		User user = new User();
        user.setId("asdfwe");
//		user.setId(1235L);
		user.setAgeName("gweweq");
		user.setAge(234);
        user.setOpenFlag(false);
		user.setEmail("eeee");
        mapper.insert(user);
	}
	@Test
	public void remove() {
		List<Long> ids = new ArrayList<>();
		ids.add(1L);
		ids.add(2L);

        boolean b = userService.removeByIds(ids);
        System.out.println(b);
    }

	@Test
	public void removeByMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "Tom");

		boolean b = userService.removeByMap(map);
		System.out.println(b);
	}

    @Test
    public void updateById() {
        User user = new User();
        user.setId("asfwefwfadfwe");
        user.setAgeName("258");
        user.setEmail("222");
        System.out.println(userService.updateById(user));
    }

    @Test
    public void update() {
        User user = new User();
        user.setAgeName("safwgasdf");
        user.setEmail("22dgqwefqwe2");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.setEntity(user);
        wrapper.like("ageName", "d");
        int update = mapper.update(user, wrapper);
        System.out.println(update);
    }

    @Test
    public void selectOne() {
        //分页信息
        int pageNow = 1;//当前页
        int pageSize = 3;//每页显示2条
        IPage<User>  page = new Page<User>(pageNow,pageSize);

        //条件
        User whereUser = new User();
        QueryWrapper<User> aa =  new QueryWrapper<User>(whereUser);
        aa.like("id", "a");
        QueryWrapper<User> queryWrapper =  new QueryWrapper<User>(whereUser);
        //模糊查询
        QueryWrapper<User> name = queryWrapper.like("age_name", "d");
        QueryWrapper<User> or = name.or(x -> aa);
        //执行
        IPage<User> usersIPage = mapper.selectPage(page, or);


        //获取查询结果
        long pages = usersIPage.getPages();//总页数
        List<User> users = usersIPage.getRecords();//当前页数据
        long total = usersIPage.getTotal();//获取总记录数

        System.out.println();
    }

    @Test
    public void list() {
        User whereUser = new User();
        QueryWrapper<User> queryWrapper =  new QueryWrapper<User>(whereUser);
        //模糊查询
//        queryWrapper.like("age_name","d");

//        PageHelper.startPage(1, 10);
        List<User> users = mapper.selectList(queryWrapper);
//        PageInfo<User> info = new PageInfo<>(users);
        System.out.println();

    }


    @Test
    public void wrapper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Map<String, Object> condition = new HashMap<>();
        condition.put("name", "o");
        condition.put("age", 20);

    }


//    @Test
//    public void listparm() {
//        //分页信息
//        int pageNow = 1;//当前页
//        int pageSize = 7;//每页显示2条
//        IPage<User>  page = new Page<User>(pageNow,pageSize);
//
//        List<String> aaa = new ArrayList<>();
//        aaa.add("aaaa");
//        aaa.add("asdfasfwe");
//        aaa.add("bbbb");
//        List<String> bbb = new ArrayList<>();
//        bbb.add("cccc");
//        bbb.add("dddd");
//        bbb.add("eeee");
//        List<User> findall = mapper.aaa(page, aaa, bbb,"aaaa");
//        page.setRecords(findall);
//        System.out.println();
//    }
}
