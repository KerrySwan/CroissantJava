import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args){
/*
        KafkaCluster KC = new KafkaCluster(Optional.of("6667"), "10.193.36.41","10.193.36.42","10.193.36.43","10.193.36.44");
        KC.getTopicNamesWithStatus().forEach(
                (k, v) -> System.out.println(k)
        );
*/
        HelloFX fx = new HelloFX();
        fx.startApp(args);


    }

}
