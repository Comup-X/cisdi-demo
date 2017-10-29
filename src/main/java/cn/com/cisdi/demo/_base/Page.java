package cn.com.cisdi.demo._base;

import lombok.*;

import java.util.List;

/**
 * 使用lombok自动生成构造器getter setter等
 *
 * @author Comup
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {
    /**
     * 当前页内容
     */
    private List<T> content;

    /**
     * 总计页数
     */
    private int totalPages;
}
