package project3.newfoodfinder.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project3.newfoodfinder.dto.ListDTO;
import project3.newfoodfinder.dto.PageRequestDTO;
import project3.newfoodfinder.dto.PageResultDTO;
import project3.newfoodfinder.entity.Testlist;

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
        for (ListDTO listDTO : resultDTO.getDtoList()){
            System.out.println(listDTO);
        }
    }
}
