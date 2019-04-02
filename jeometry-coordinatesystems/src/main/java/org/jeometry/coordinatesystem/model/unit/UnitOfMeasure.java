package org.jeometry.coordinatesystem.model.unit;

import java.util.Arrays;
import java.util.List;

public interface UnitOfMeasure {
  static List<String> TYPE_NAMES = Arrays.asList("scale", "length", "angle", "time");

  UnitOfMeasureType getType();

  default boolean isSame(final UnitOfMeasure unit) {
    return equals(unit);
  }

  @SuppressWarnings("unchecked")
  default <U extends UnitOfMeasure> ValueWithUnit<U> newValue(final double value) {
    return (ValueWithUnit<U>)new ValueWithUnit<>(this, value);
  }

  double toBase(final double value);

  default double toNormal(final double value) {
    return toBase(value);
  }
}
