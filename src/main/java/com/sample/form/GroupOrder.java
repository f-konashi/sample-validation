package com.sample.form;

import javax.validation.GroupSequence;

@GroupSequence({GroupOrder1.class, GroupOrder2.class, GroupOrder3.class, GroupOrder4.class})
public interface GroupOrder {
}
