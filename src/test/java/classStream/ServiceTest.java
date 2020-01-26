package classStream;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    Service service=new Service();
/*
"{Paweł=1, Karol=1, Darek=1, Marek=1}"
 */
    @Test
    void workersPerName() {
        Map<String,Long> map=new HashMap<>();
        map.put("Paweł",Long.valueOf(1));
        map.put("Karol",Long.valueOf(1));
        map.put("Darek",Long.valueOf(1));
        map.put("Marek",Long.valueOf(1));
        assertEquals(map,service.workersPerName());
    }
}