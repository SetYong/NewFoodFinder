package project3.newfoodfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project3.newfoodfinder.entity.FoodBoard;
import project3.newfoodfinder.repository.FoodBoardRepository;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class FoodServiceImpl {

    @Autowired
    private FoodBoardRepository foodBoardRepository;

    public void write(FoodBoard foodBoard, MultipartFile file) throws Exception{
        String projechPath = System.getProperty("user.dir")
                + "\\src\\main\\resources\\static\\files";
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + file.getOriginalFilename();
        File saveFile = new File(projechPath, fileName);
        file.transferTo(saveFile);
        foodBoard.setImage(fileName);
        foodBoard.setImagepath("/files/"+fileName);
        foodBoardRepository.save(foodBoard);
    }

    public List<FoodBoard> boardList(){
        return foodBoardRepository.findAll();
    }

    public FoodBoard foodBoardView(Long headnum){
        return foodBoardRepository.findById(headnum).get();
    }

    public void foodBoardDelete(Long headnum){
        foodBoardRepository.deleteById(headnum);
    }
}
