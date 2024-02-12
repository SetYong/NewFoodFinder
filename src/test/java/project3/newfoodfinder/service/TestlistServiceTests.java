package project3.newfoodfinder.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestlistServiceTests {

    @Autowired
    private TestlistService service;

    @Test
    public void testRegister(){
        ListDTO listDTO = ListDTO.builder()
                .title("Sample Title..")
                .content("Sample Content..")
                .writer("Sample Writer..")
                .build();
        System.out.println(service.register(listDTO));
    }

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
        PageResultDTO<ListDTO, Testlist> resultDTO = service.getList(pageRequestDTO);
        System.out.println("PREV: "+resultDTO.isPrev());
        System.out.println("NEXT: "+resultDTO.isNext());
        System.out.println("TOTAL: "+resultDTO.getTotalPage());
        System.out.println("-------------------------------------------");
        for (ListDTO listDTO : resultDTO.getDtoList()){
            System.out.println(listDTO);
        }
        System.out.println("===========================================");
        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }

    @Test
    public void testSearch(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .type("tc")
                .keyword("S")
                .build();
        PageResultDTO<ListDTO, Testlist> resultDTO = service.getList(pageRequestDTO);
        System.out.println("PREV: "+resultDTO.isPrev());
        System.out.println("NEXT: "+resultDTO.isNext());
        System.out.println("TOTAL: "+resultDTO.getTotalPage());
        System.out.println("---------------------------------");
        for(ListDTO listDTO : resultDTO.getDtoList()){
            System.out.println(listDTO);
        }
        System.out.println("=================================");
        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }
}
