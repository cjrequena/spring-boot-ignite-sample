package com.cjrequena.sample.fooserverservice.ws.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.cjrequena.sample.fooserverservice.dto.FooDTOV1;
import com.cjrequena.sample.fooserverservice.exception.ServiceException;
import com.cjrequena.sample.fooserverservice.service.FooServiceV1;
import org.springframework.stereotype.Component;

@Component
public class FooQuery implements GraphQLQueryResolver {

  private FooServiceV1 fooServiceV1;

  /**
   *
   * @param fooServiceV1
   */
  public FooQuery(FooServiceV1 fooServiceV1) {
    this.fooServiceV1 = fooServiceV1;
  }

  /**
   *
   * @param filters
   * @param offset
   * @param limit
   * @return
   * @throws ServiceException
   */
  public Iterable<FooDTOV1> fooes(String filters, Integer offset, Integer limit) throws ServiceException {
    return this.fooServiceV1.retrieve(filters, null, limit, offset).getContent();
  }

  /**
   *
   * @param id
   * @return
   * @throws ServiceException
   */
  public FooDTOV1 fooById(Long id) throws ServiceException {
    return this.fooServiceV1.retrieveById(id);
  }
}
