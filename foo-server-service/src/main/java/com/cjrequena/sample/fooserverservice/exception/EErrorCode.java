package com.cjrequena.sample.fooserverservice.exception;

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
public enum EErrorCode {

  NOT_CONTENT_ERROR("FSS-ERROR-000204"),
  NOT_MODIFIED_ERROR("FSS-ERROR-000304"),
  BAD_REQUEST_ERROR("FSS-ERROR-000400"),
  NOT_FOUND_ERROR("FSS-ERROR-000404"),
  CONFLICT_ERROR("FSS-ERROR-000409"),
  INTERNAL_SERVER_ERROR("FSS-ERROR-000500"),
  EVENT_NOTIFICATION_ERROR("FSS-ERROR-001000");

  private String errorCode;

  /**
   *
   * @param errorCode
   */
  EErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  /**
   *
   * @return
   */
  public String getErrorCode() {
    return this.errorCode;
  }

}


