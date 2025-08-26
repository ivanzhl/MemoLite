package memolite.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopicService {
    private final List<String> topics = new ArrayList<>();
    private final ObjectMapper mapper = new ObjectMapper();
    private final File file = new File("topics.json");

    public TopicService() {
        loadTopics();
    }

    public List<String> getTopics() {
        return topics;
    }

    public void addTopic(String topic) {
        if (topic != null && !topic.isBlank()) {
            topics.add(topic.trim());
            saveTopics();
        }
    }

    public void removeTopic(String topic) {
        topics.remove(topic);
        saveTopics();
    }

    public String shuffleTopic() {
        if (topics.isEmpty()) return "No topics available.";
        Collections.shuffle(topics);
        return topics.get(0);
    }

    private void loadTopics() {
        if (file.exists()) {
            try {
                List<String> loaded = mapper.readValue(file, new TypeReference<>() {});
                topics.clear();
                topics.addAll(loaded);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveTopics() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, topics);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
