package com.cjrequena.sample.fooserverservice.mapper;

import com.cjrequena.sample.fooserverservice.dto.BooDTOV1;
import com.cjrequena.sample.fooserverservice.db.entity.BooEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

/**
 * <p>
 * <p>
 * <p>
 * <p>
 * @author cjrequena
 * @version 1.0
 * @since JDK1.8
 * @see
 *
 */
@Mapper(
  componentModel = "spring",
  nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface BooDtoEntityMapper extends DTOEntityMapper<BooDTOV1, BooEntity> {
}
