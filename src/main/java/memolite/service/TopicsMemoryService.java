package memolite.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import memolite.constants.ViewMessages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TopicsMemoryService {
    private final List<String> topics = new ArrayList<>();
    private final ObjectMapper mapper = new ObjectMapper();
    private final File file = new File("userdata/topics.json");

    private final ShuffleCycleService shuffleCycleService;

    public TopicsMemoryService() {
        loadTopics();
        this.shuffleCycleService = new ShuffleCycleService(topics);
    }

    public void startNewSession() {
        shuffleCycleService.startNewSession();
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
        if (topics.remove(topic)) {
            saveTopics();
        }
    }

    public String getTopic() {
        if (topics.isEmpty()) return ViewMessages.EMPTY_TOPIC_LIST;

        String topic = shuffleCycleService.getCurrentTopicAndMoveToNext();
        if (topic == null) {
            shuffleCycleService.startNewSession();
            return ViewMessages.CYCLE_COMPLETE;
        }
        return topic;
    }

    private void loadTopics() {
        if (file.exists()) {
            try {
                List<String> loaded = mapper.readValue(file, new TypeReference<>() {
                });
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
