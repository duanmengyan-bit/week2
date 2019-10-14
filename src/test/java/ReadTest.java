import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;

import com.duanmengyan.utils.RandomUtil;
import com.duanmengyan.utils.StreamUtil;
import com.duanmengyan.utils.StringUtil;
import com.duanmengyan.week.domain.Goods;

@ContextConfiguration(locations = "spring-beans.xml")
public class ReadTest {
	@Autowired
	RedisTemplate redisTemplate;
	@Test//读取五初始数据文件里的东西
	public void readFileTest() throws IOException {
		//BufferedReader b = new BufferedReader(new FileReader("五初始数据.txt"));
		List<String> readTest = StreamUtil.readTest("五初始数据.txt");
		for (String string : readTest) {
			String[] split = string.split("//==");
			Goods g = new Goods();
			for (int i = 0; i < split.length; i++) {
				g.setId(Integer.parseInt(split[0].trim()));
				g.setName(split[1]);
				/* g.setPrice(split[2]); */
				g.setBaifen(split[3]);
				
			}
			redisTemplate.opsForList().leftPush("getList", g);//存到redis
			
		}
	}
	@SuppressWarnings("unchecked")
	@Test
	public void addList() {//用list在redis中添加数据
		for (int i = 1; i <=106 ; i++) {
			Goods g = new Goods();
			g.setId(i);
			g.setName("商品"+i);
			g.setPrice(null);
			g.setBaifen(i+":"+"90%");
			redisTemplate.opsForList().leftPush("readList", g);
		}
	}
	
	@Test
	public void addset() {
		for (int i = 1; i <=106 ; i++) {
			Goods g = new Goods();
			g.setId(i);
			g.setName("商品"+i);
			g.setPrice(null);
			g.setBaifen(i+":"+"90%");
			redisTemplate.opsForZSet().add("getZsize", g, i);
		}
	}
	@Test
	public void isnumber() {
		String id="1";
		boolean number = StringUtil.isNumber(id);
		if (number) {
			System.out.println("是数字");
		}else {
			System.out.println("不是");
		}
	}
	@Test
	public void haveTest() {
		String name1 ="黄";
		boolean hasText = StringUtil.hasText(name1);
		if (hasText) {
			System.out.println("不是空");
		}else {
			System.out.println("是空");
		}
	}
	@Test
	public void haveTestprice() {
		
		String price="111";
		if (StringUtil.hasText(price)) {
			
			boolean hasText = StringUtil.hasText1(price);
			if (hasText) {
				System.out.println("不是空");
			}else {
				System.out.println("是空");
			}
		}else {
			boolean number = StringUtil.isNumber(price);
			if (number) {
				System.out.println("数字");
			}else {
				System.out.println("不是");
			}
		}
	}
	
	@Test
	public void baifenTest() {
		String baifen="";
		if (StringUtil.hasText(baifen)) {
			
		}else {
			boolean number = StringUtil.isNumber(baifen);
			if (number) {
				System.out.println("是数字");
			}else {
				System.out.println("不是数字");
			}
		}
	}
}
