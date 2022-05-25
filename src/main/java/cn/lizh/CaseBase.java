package cn.lizh;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 测试案例
 *
 * @param <P>
 * @param <T>
 */
@Data
@AllArgsConstructor
public class CaseBase<P, T> {
    P params;
    T result;
}
