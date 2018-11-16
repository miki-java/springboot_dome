package com.example.demo.common;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * Created by hmq on 2018/11/14.
 */
@GroupSequence({ Default.class, UpdateGroup.class, SaveGroup.class })
public interface Group {
}
