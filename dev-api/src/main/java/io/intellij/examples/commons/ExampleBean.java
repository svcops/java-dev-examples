package io.intellij.examples.commons;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * ExampleBean
 *
 * @author tech@intellij.io
 */
@Builder(builderMethodName = "of")
@ToString
@Data
public class ExampleBean {
    private Long id;
    private String name;
    private Date ts;
}
