package memolite.service;

import java.util.Collections;
import java.util.List;

public class ShuffleService {

    private final List<String> topics;
    private int currentTopicIndex;

    public ShuffleService(List<String> topics) {
        this.topics = topics;
        this.currentTopicIndex = 0;
    }

    public void startNewSession() {
        if (topics.isEmpty()) return;
        Collections.shuffle(topics);
        currentTopicIndex = 0;
    }

    public String getCurrentTopicAndMoveToNext() {
        if (currentTopicIndex >= topics.size()) return null;

        String current = topics.get(currentTopicIndex);
        currentTopicIndex++;
        return current;
    }
}
