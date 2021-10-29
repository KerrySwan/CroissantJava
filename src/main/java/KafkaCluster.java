import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.streams.*;

import java.util.*;
import java.util.stream.Collectors;

public class KafkaCluster{

    Properties props;
    Serde<String> serde;
    StreamsBuilder builder;
    StreamsConfig streamsConfig;

    //defaults
    String[] DEFAULT_IP = new String[]{"localhost"};
    String DEFAULT_PORT = "8000";

    KafkaCluster(Optional<String> port, String... ip){
        props = new Properties();
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

        serde = new Serdes.StringSerde();                                                                               //class required to serialize-deserialize keys and values of input
        builder = new StreamsBuilder();

        this.setBootstrapServer(port, Optional.of(ip));


    }

    /**
     * Set ips and port for kafka cluster into *props* value.
     * In case ip empty set *ip* to localhost value
     */
    final private Properties setBootstrapServer(Optional<String> port, Optional<String[]> ip ){
        String s_port = port.orElse(DEFAULT_PORT);
        String[] a_ip = ip.orElse(DEFAULT_IP);
        String bootstrap = Arrays.stream(a_ip).map(x -> x + ":" + s_port).collect(Collectors.joining(","));

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
        return props;

    }

    Map<String, List<PartitionInfo>> getTopicNamesWithStatus(){                                                         //todo: divide class into to for Cluster init and Cluster requests
        KafkaConsumer consumer = new KafkaConsumer<String, String>(props);                                              //create cons var for current properties   todo: put this val out of method? Make it global?
        return consumer.listTopics();

    }


}
