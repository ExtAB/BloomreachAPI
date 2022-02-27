package Pages;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContentData {
        String name;
        String type;
        String path;
        String By;
        String Published;
        String Translations;
}