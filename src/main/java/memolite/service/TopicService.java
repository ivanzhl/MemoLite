package memolite.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopicService {
    private final List<String> topics = new ArrayList<>();

    public void addTopic(String topic) {
        if (topic != null && !topic.isBlank()) {
            topics.add(topic.trim());
        }
    }

    public String shuffleTopic() {
        if (topics.isEmpty()) return "No topics available.";
        Collections.shuffle(topics);
        return topics.getFirst();
    }
}
