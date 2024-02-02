package project3.newfoodfinder.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import project3.newfoodfinder.entity.QTestlist;

import java.util.stream.IntStream;

@SpringBootTest
public class TestlistRepositoryTests {

    @Autowired
    private TestlistRepository testlistRepository;
    @Test
    public void insertDummies2(){
        IntStream.rangeClosed(1,40).forEach(i ->{
            Testlist testlist = Testlist.builder()
                    .title("Title.."+i)
                    .content("Content.."+i)
                    .writer("writer.."+(i%10))
                    .build();
            System.out.println(testlistRepository.save(testlist));
        });
    }

    @Test
    public void testQuery1(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("listno").descending());
        QTestlist qTestlist = QTestlist.testlist;
        String keyword = "1";
        BooleanBuilder builder = new BooleanBuilder();
        BooleanExpression expression = qTestlist.title.contains(keyword);
        builder.and(expression);
        Page<Testlist> result = testlistRepository.findAll(builder, pageable);
        result.stream().forEach(testlist -> {
            System.out.println(testlist);
        });
    }

    @Test
    public void testQuery2(){
        Pageable pageable = PageRequest.of(0,10,Sort.by("listno").descending());
        QTestlist qTestlist = QTestlist.testlist;
        String keyword = "1";
        BooleanBuilder builder = new BooleanBuilder();
        BooleanExpression exTitle = qTestlist.title.contains(keyword);
        BooleanExpression exContent = qTestlist.content.contains(keyword);
        BooleanExpression exAll = exTitle.or(exContent);
        builder.and(exAll);
        builder.and(qTestlist.listno.gt(0L));
        Page<Testlist> result = testlistRepository.findAll(builder, pageable);
        result.stream().forEach(testlist -> {
            System.out.println(testlist);
        });
    }

}
