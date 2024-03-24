package shop.mtcoding.blog.board;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Import(BoardNativeRepository.class)
@DataJpaTest
public class BoardNativeRepositoryTest {
    @Autowired // DI
    private BoardNativeRepository boardNativeRepository;

    @Test
    public void findAll_test() {
        //given

        //when
        List<Board> boardList = boardNativeRepository.findAll();

        //then
        System.out.println("findAll_test/size : " + boardList.size());
        System.out.println("findAll_test/username : " + boardList.get(2).getUsername());  //cos인지 확인하고 싶다

        assertThat(boardList.size()).isEqualTo(4);
        assertThat(boardList.get(3).getUsername()).isEqualTo("ssar");
    }
}
