package com.theblackdre1d.semestralka;

import com.theblackdre1d.semestralka.models.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> mTopics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Some description"),
            new Topic("django", "Django Framework", "Some description"),
            new Topic("react", "React Framework", "Some description"),
            new Topic("angular", "Angular Framework", "Some description")
    ));

    public List<Topic> getAllTopics() {
        return mTopics;
    }

    public Topic getTopicByID(String id) {
        return mTopics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        mTopics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for (int i = 0; i < mTopics.size(); i++) {
            Topic tmpTopic = mTopics.get(i);
            if (tmpTopic.getId().equals(topic.getId())) {
                mTopics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        mTopics.removeIf( t -> t.getId().equals(id));
    }
}
