package memolite.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TopicService {
    private final List<String> topics = new ArrayList<>();
    private final ObjectMapper mapper = new ObjectMapper();
    private final File storageFile = new File("userdata/topics.json");
    private final Random random = new Random();

    public TopicService() {
        loadTopics();
    }

    public void addTopic(String topic) {
        if (topic != null && !topic.isBlank()) {
            topics.add(topic.trim());
            saveTopics();
        }
    }

    public String shuffleTopic() {
        if (topics.isEmpty()) {
            return "No topics available";
        }
        return topics.get(random.nextInt(topics.size()));
    }

    public List<String> getAllTopics() {
        return new ArrayList<>(topics);
    }

    private void saveTopics() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(storageFile, topics);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTopics() {
        if (storageFile.exists()) {
            try {
                List<String> loaded = mapper.readValue(storageFile, new TypeReference<>() {});
                topics.clear();
                topics.addAll(loaded);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
