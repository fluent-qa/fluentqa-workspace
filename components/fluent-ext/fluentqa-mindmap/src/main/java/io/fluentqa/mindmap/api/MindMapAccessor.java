package io.fluentqa.mindmap.api;

import io.fluentqa.mindmap.freemind.FreeMindTransformer;
import io.fluentqa.mindmap.xmind.XmindTransformer;

import java.util.List;


public class MindMapAccessor {

    public <T> List<T> readMindMapToBean(String fileName, Class<T> clazz){
        MindMapTransformer transformer = selectTransformer(fileName);
        return transformer.readMindMapToList(fileName,clazz);
    }

    public <T> List<T> readMindMapToBean(String fileName, Class<T> clazz,MindMapConvertConfig config){
        MindMapTransformer transformer = selectTransformer(fileName);
        return transformer.readMindMapToList(fileName,clazz,config);
    }
    public List<MindMapPath> readMindMap(String fileName) {
        MindMapTransformer transformer = selectTransformer(fileName);
        return transformer.readMindMapToList(fileName);
    }

    private MindMapTransformer selectTransformer(String fileName) {
        switch (MindmapTypeEnum.XMIND.parse(fileName)) {
            case FREEMIND:
                return new FreeMindTransformer();
            case XMIND:
            default:
                return new XmindTransformer();
        }
    }




}
