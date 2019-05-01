package com.tarasovs.civetweb

import scala.scalanative._
import scala.scalanative.native._

@native.link("civetweb")
@native.extern
object Bindings {
  type enum_anonymous_0 = native.CUnsignedInt
  object enum_anonymous_0 {
    final val MG_FEATURES_DEFAULT: enum_anonymous_0 = 0.toUInt
    final val MG_FEATURES_FILES: enum_anonymous_0 = 1.toUInt
    final val MG_FEATURES_TLS: enum_anonymous_0 = 2.toUInt
    final val MG_FEATURES_SSL: enum_anonymous_0 = 2.toUInt
    final val MG_FEATURES_CGI: enum_anonymous_0 = 4.toUInt
    final val MG_FEATURES_IPV6: enum_anonymous_0 = 8.toUInt
    final val MG_FEATURES_WEBSOCKET: enum_anonymous_0 = 16.toUInt
    final val MG_FEATURES_LUA: enum_anonymous_0 = 32.toUInt
    final val MG_FEATURES_SSJS: enum_anonymous_0 = 64.toUInt
    final val MG_FEATURES_CACHE: enum_anonymous_0 = 128.toUInt
    final val MG_FEATURES_STATS: enum_anonymous_0 = 256.toUInt
    final val MG_FEATURES_COMPRESSION: enum_anonymous_0 = 512.toUInt
    final val MG_FEATURES_ALL: enum_anonymous_0 = 65535.toUInt
  }

  type enum_anonymous_1 = native.CUnsignedInt
  object enum_anonymous_1 {
    final val MG_CONFIG_TYPE_UNKNOWN: enum_anonymous_1 = 0.toUInt
    final val MG_CONFIG_TYPE_NUMBER: enum_anonymous_1 = 1.toUInt
    final val MG_CONFIG_TYPE_STRING: enum_anonymous_1 = 2.toUInt
    final val MG_CONFIG_TYPE_FILE: enum_anonymous_1 = 3.toUInt
    final val MG_CONFIG_TYPE_DIRECTORY: enum_anonymous_1 = 4.toUInt
    final val MG_CONFIG_TYPE_BOOLEAN: enum_anonymous_1 = 5.toUInt
    final val MG_CONFIG_TYPE_EXT_PATTERN: enum_anonymous_1 = 6.toUInt
    final val MG_CONFIG_TYPE_STRING_LIST: enum_anonymous_1 = 7.toUInt
    final val MG_CONFIG_TYPE_STRING_MULTILINE: enum_anonymous_1 = 8.toUInt
    final val MG_CONFIG_TYPE_YES_NO_OPTIONAL: enum_anonymous_1 = 9.toUInt
  }

  type enum_anonymous_2 = native.CUnsignedInt
  object enum_anonymous_2 {
    final val MG_WEBSOCKET_OPCODE_CONTINUATION: enum_anonymous_2 = 0.toUInt
    final val MG_WEBSOCKET_OPCODE_TEXT: enum_anonymous_2 = 1.toUInt
    final val MG_WEBSOCKET_OPCODE_BINARY: enum_anonymous_2 = 2.toUInt
    final val MG_WEBSOCKET_OPCODE_CONNECTION_CLOSE: enum_anonymous_2 = 8.toUInt
    final val MG_WEBSOCKET_OPCODE_PING: enum_anonymous_2 = 9.toUInt
    final val MG_WEBSOCKET_OPCODE_PONG: enum_anonymous_2 = 10.toUInt
  }

  type enum_anonymous_3 = native.CUnsignedInt
  object enum_anonymous_3 {
    final val MG_FORM_FIELD_STORAGE_SKIP: enum_anonymous_3 = 0.toUInt
    final val MG_FORM_FIELD_STORAGE_GET: enum_anonymous_3 = 1.toUInt
    final val MG_FORM_FIELD_STORAGE_STORE: enum_anonymous_3 = 2.toUInt
    final val MG_FORM_FIELD_STORAGE_ABORT: enum_anonymous_3 = 16.toUInt
  }

  type enum_anonymous_4 = native.CUnsignedInt
  object enum_anonymous_4 {
    final val MG_FORM_FIELD_HANDLE_GET: enum_anonymous_4 = 1.toUInt
    final val MG_FORM_FIELD_HANDLE_NEXT: enum_anonymous_4 = 8.toUInt
    final val MG_FORM_FIELD_HANDLE_ABORT: enum_anonymous_4 = 16.toUInt
  }

  type enum_anonymous_5 = native.CInt
  object enum_anonymous_5 {
    final val TIMEOUT_INFINITE: enum_anonymous_5 = -1
  }

  type enum_anonymous_6 = native.CInt
  object enum_anonymous_6 {
    final val MG_TIMEOUT_INFINITE: enum_anonymous_6 = -1
  }

  type struct_mg_header = native.CStruct2[native.CString, native.CString]
  type struct_mg_client_cert = native.CStruct5[native.Ptr[Byte], native.CString, native.CString, native.CString, native.CString]
  type struct_mg_request_info = native.CStruct16[native.CString, native.CString, native.CString, native.CString, native.CString, native.CString, native.CArray[native.CChar, native.Nat.Digit[native.Nat._4, native.Nat._8]], native.CLongLong, native.CInt, native.CInt, native.Ptr[Byte], native.Ptr[Byte], native.CInt, native.CArray[struct_mg_header, native.Nat.Digit[native.Nat._6, native.Nat._4]], native.Ptr[struct_mg_client_cert], native.CString]
  type struct_mg_response_info = native.CStruct6[native.CInt, native.CString, native.CString, native.CLongLong, native.CInt, native.CArray[struct_mg_header, native.Nat.Digit[native.Nat._6, native.Nat._4]]]
  type struct_mg_connection = native.CStruct0 // incomplete type
  type struct_mg_context = native.CStruct0 // incomplete type
  type struct_mg_callbacks = native.CStruct13[native.CFunctionPtr1[native.Ptr[struct_mg_connection], native.CInt], native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.CInt, Unit], native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.CString, native.CInt], native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.CString, native.CInt], native.CFunctionPtr2[native.Ptr[Byte], native.Ptr[Byte], native.CInt], native.CFunctionPtr2[native.Ptr[native.Ptr[Byte]], native.Ptr[Byte], native.CInt], native.CFunctionPtr1[native.Ptr[struct_mg_connection], Unit], native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], Unit], native.CFunctionPtr3[native.Ptr[struct_mg_connection], native.CInt, native.CString, native.CInt], native.CFunctionPtr1[native.Ptr[struct_mg_context], Unit], native.CFunctionPtr2[native.Ptr[struct_mg_context], native.CInt, Unit], native.CFunctionPtr1[native.Ptr[struct_mg_context], Unit], native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[native.Ptr[Byte]], native.CInt]]
  type mg_request_handler = native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], native.CInt]
  type mg_websocket_connect_handler = native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], native.CInt]
  type mg_websocket_ready_handler = native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], Unit]
  type mg_websocket_data_handler = native.CFunctionPtr5[native.Ptr[struct_mg_connection], native.CInt, native.CString, native.CSize, native.Ptr[Byte], native.CInt]
  type mg_websocket_close_handler = native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], Unit]
  type struct_mg_websocket_subprotocols = native.CStruct2[native.CInt, native.Ptr[native.CString]]
  type mg_authorization_handler = native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], native.CInt]
  type struct_mg_option = native.CStruct3[native.CString, native.CInt, native.CString]
  type struct_mg_server_ports = native.CStruct8[native.CInt, native.CInt, native.CInt, native.CInt, native.CInt, native.CInt, native.CInt, native.CInt]
  type struct_mg_form_data_handler = native.CStruct4[native.CFunctionPtr5[native.CString, native.CString, native.CString, native.CSize, native.Ptr[Byte], native.CInt], native.CFunctionPtr4[native.CString, native.CString, native.CSize, native.Ptr[Byte], native.CInt], native.CFunctionPtr3[native.CString, native.CLongLong, native.Ptr[Byte], native.CInt], native.Ptr[Byte]]
  type mg_thread_func_t = native.CFunctionPtr1[native.Ptr[Byte], native.Ptr[Byte]]
  type struct_mg_client_options = native.CStruct4[native.CString, native.CInt, native.CString, native.CString]
  def mg_init_library(features: native.CUnsignedInt): native.CUnsignedInt = native.extern
  def mg_exit_library(): native.CUnsignedInt = native.extern
  def mg_start(callbacks: native.Ptr[struct_mg_callbacks], user_data: native.Ptr[Byte], configuration_options: native.Ptr[native.CString]): native.Ptr[struct_mg_context] = native.extern
  def mg_stop(p0: native.Ptr[struct_mg_context]): Unit = native.extern
  def mg_set_request_handler(ctx: native.Ptr[struct_mg_context], uri: native.CString, handler: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], native.CInt], cbdata: native.Ptr[Byte]): Unit = native.extern
  def mg_set_websocket_handler(ctx: native.Ptr[struct_mg_context], uri: native.CString, connect_handler: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], native.CInt], ready_handler: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], Unit], data_handler: native.CFunctionPtr5[native.Ptr[struct_mg_connection], native.CInt, native.CString, native.CSize, native.Ptr[Byte], native.CInt], close_handler: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], Unit], cbdata: native.Ptr[Byte]): Unit = native.extern
  def mg_set_websocket_handler_with_subprotocols(ctx: native.Ptr[struct_mg_context], uri: native.CString, subprotocols: native.Ptr[struct_mg_websocket_subprotocols], connect_handler: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], native.CInt], ready_handler: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], Unit], data_handler: native.CFunctionPtr5[native.Ptr[struct_mg_connection], native.CInt, native.CString, native.CSize, native.Ptr[Byte], native.CInt], close_handler: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], Unit], cbdata: native.Ptr[Byte]): Unit = native.extern
  def mg_set_auth_handler(ctx: native.Ptr[struct_mg_context], uri: native.CString, handler: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], native.CInt], cbdata: native.Ptr[Byte]): Unit = native.extern
  def mg_get_option(ctx: native.Ptr[struct_mg_context], name: native.CString): native.CString = native.extern
  def mg_get_context(conn: native.Ptr[struct_mg_connection]): native.Ptr[struct_mg_context] = native.extern
  def mg_get_user_data(ctx: native.Ptr[struct_mg_context]): native.Ptr[Byte] = native.extern
  def mg_set_user_connection_data(conn: native.Ptr[struct_mg_connection], data: native.Ptr[Byte]): Unit = native.extern
  def mg_get_user_connection_data(conn: native.Ptr[struct_mg_connection]): native.Ptr[Byte] = native.extern
  def mg_get_request_link(conn: native.Ptr[struct_mg_connection], buf: native.CString, buflen: native.CSize): native.CInt = native.extern
  def mg_get_valid_options(): native.Ptr[struct_mg_option] = native.extern
  def mg_get_server_ports(ctx: native.Ptr[struct_mg_context], size: native.CInt, ports: native.Ptr[struct_mg_server_ports]): native.CInt = native.extern
  def mg_modify_passwords_file(passwords_file_name: native.CString, realm: native.CString, user: native.CString, password: native.CString): native.CInt = native.extern
  def mg_get_request_info(p0: native.Ptr[struct_mg_connection]): native.Ptr[struct_mg_request_info] = native.extern
  def mg_get_response_info(p0: native.Ptr[struct_mg_connection]): native.Ptr[struct_mg_response_info] = native.extern
  def mg_write(p0: native.Ptr[struct_mg_connection], buf: native.Ptr[Byte], len: native.CSize): native.CInt = native.extern
  def mg_websocket_write(conn: native.Ptr[struct_mg_connection], opcode: native.CInt, data: native.CString, data_len: native.CSize): native.CInt = native.extern
  def mg_websocket_client_write(conn: native.Ptr[struct_mg_connection], opcode: native.CInt, data: native.CString, data_len: native.CSize): native.CInt = native.extern
  def mg_lock_connection(conn: native.Ptr[struct_mg_connection]): Unit = native.extern
  def mg_unlock_connection(conn: native.Ptr[struct_mg_connection]): Unit = native.extern
  def mg_lock_context(ctx: native.Ptr[struct_mg_context]): Unit = native.extern
  def mg_unlock_context(ctx: native.Ptr[struct_mg_context]): Unit = native.extern
  def mg_printf(p0: native.Ptr[struct_mg_connection], fmt: native.CString, varArgs: native.CVararg*): native.CInt = native.extern
  def mg_send_chunk(conn: native.Ptr[struct_mg_connection], chunk: native.CString, chunk_len: native.CUnsignedInt): native.CInt = native.extern
  def mg_send_file(conn: native.Ptr[struct_mg_connection], path: native.CString): Unit = native.extern
  def mg_send_file_body(conn: native.Ptr[struct_mg_connection], path: native.CString): native.CInt = native.extern
  def mg_send_http_error(conn: native.Ptr[struct_mg_connection], status_code: native.CInt, fmt: native.CString, varArgs: native.CVararg*): native.CInt = native.extern
  def mg_send_http_ok(conn: native.Ptr[struct_mg_connection], mime_type: native.CString, content_length: native.CLongLong): native.CInt = native.extern
  def mg_send_http_redirect(conn: native.Ptr[struct_mg_connection], target_url: native.CString, redirect_code: native.CInt): native.CInt = native.extern
  def mg_send_digest_access_authentication_request(conn: native.Ptr[struct_mg_connection], realm: native.CString): native.CInt = native.extern
  def mg_check_digest_access_authentication(conn: native.Ptr[struct_mg_connection], realm: native.CString, filename: native.CString): native.CInt = native.extern
  def mg_send_mime_file(conn: native.Ptr[struct_mg_connection], path: native.CString, mime_type: native.CString): Unit = native.extern
  def mg_send_mime_file2(conn: native.Ptr[struct_mg_connection], path: native.CString, mime_type: native.CString, additional_headers: native.CString): Unit = native.extern
  def mg_store_body(conn: native.Ptr[struct_mg_connection], path: native.CString): native.CLongLong = native.extern
  def mg_read(p0: native.Ptr[struct_mg_connection], buf: native.Ptr[Byte], len: native.CSize): native.CInt = native.extern
  def mg_get_header(p0: native.Ptr[struct_mg_connection], name: native.CString): native.CString = native.extern
  def mg_get_var(data: native.CString, data_len: native.CSize, var_name: native.CString, dst: native.CString, dst_len: native.CSize): native.CInt = native.extern
  def mg_get_var2(data: native.CString, data_len: native.CSize, var_name: native.CString, dst: native.CString, dst_len: native.CSize, occurrence: native.CSize): native.CInt = native.extern
  def mg_get_cookie(cookie: native.CString, var_name: native.CString, buf: native.CString, buf_len: native.CSize): native.CInt = native.extern
  def mg_download(host: native.CString, port: native.CInt, use_ssl: native.CInt, error_buffer: native.CString, error_buffer_size: native.CSize, request_fmt: native.CString, varArgs: native.CVararg*): native.Ptr[struct_mg_connection] = native.extern
  def mg_close_connection(conn: native.Ptr[struct_mg_connection]): Unit = native.extern
  def mg_handle_form_request(conn: native.Ptr[struct_mg_connection], fdh: native.Ptr[struct_mg_form_data_handler]): native.CInt = native.extern
  def mg_start_thread(f: native.CFunctionPtr1[native.Ptr[Byte], native.Ptr[Byte]], p: native.Ptr[Byte]): native.CInt = native.extern
  def mg_get_builtin_mime_type(file_name: native.CString): native.CString = native.extern
  def mg_get_response_code_text(conn: native.Ptr[struct_mg_connection], response_code: native.CInt): native.CString = native.extern
  def mg_version(): native.CString = native.extern
  def mg_url_decode(src: native.CString, src_len: native.CInt, dst: native.CString, dst_len: native.CInt, is_form_url_encoded: native.CInt): native.CInt = native.extern
  def mg_url_encode(src: native.CString, dst: native.CString, dst_len: native.CSize): native.CInt = native.extern
  def mg_md5(buf: native.CString, varArgs: native.CVararg*): native.CString = native.extern
  def mg_cry(conn: native.Ptr[struct_mg_connection], fmt: native.CString, varArgs: native.CVararg*): Unit = native.extern
  def mg_strcasecmp(s1: native.CString, s2: native.CString): native.CInt = native.extern
  def mg_strncasecmp(s1: native.CString, s2: native.CString, len: native.CSize): native.CInt = native.extern
  def mg_connect_websocket_client(host: native.CString, port: native.CInt, use_ssl: native.CInt, error_buffer: native.CString, error_buffer_size: native.CSize, path: native.CString, origin: native.CString, data_func: native.CFunctionPtr5[native.Ptr[struct_mg_connection], native.CInt, native.CString, native.CSize, native.Ptr[Byte], native.CInt], close_func: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], Unit], user_data: native.Ptr[Byte]): native.Ptr[struct_mg_connection] = native.extern
  def mg_connect_client(host: native.CString, port: native.CInt, use_ssl: native.CInt, error_buffer: native.CString, error_buffer_size: native.CSize): native.Ptr[struct_mg_connection] = native.extern
  def mg_connect_client_secure(client_options: native.Ptr[struct_mg_client_options], error_buffer: native.CString, error_buffer_size: native.CSize): native.Ptr[struct_mg_connection] = native.extern
  def mg_get_response(conn: native.Ptr[struct_mg_connection], ebuf: native.CString, ebuf_len: native.CSize, timeout: native.CInt): native.CInt = native.extern
  def mg_check_feature(feature: native.CUnsignedInt): native.CUnsignedInt = native.extern
  def mg_get_system_info(buffer: native.CString, buflen: native.CInt): native.CInt = native.extern
  def mg_get_context_info(ctx: native.Ptr[struct_mg_context], buffer: native.CString, buflen: native.CInt): native.CInt = native.extern

  object defines {
    val CIVETWEB_VERSION: native.CString = c"1.11"
  }

  object implicits {
    implicit class struct_mg_header_ops(val p: native.Ptr[struct_mg_header]) extends AnyVal {
      def name: native.CString = !p._1
      def name_=(value: native.CString): Unit = !p._1 = value
      def value: native.CString = !p._2
      def value_=(value: native.CString): Unit = !p._2 = value
    }

    implicit class struct_mg_request_info_ops(val p: native.Ptr[struct_mg_request_info]) extends AnyVal {
      def request_method: native.CString = !p._1
      def request_method_=(value: native.CString): Unit = !p._1 = value
      def request_uri: native.CString = !p._2
      def request_uri_=(value: native.CString): Unit = !p._2 = value
      def local_uri: native.CString = !p._3
      def local_uri_=(value: native.CString): Unit = !p._3 = value
      def http_version: native.CString = !p._4
      def http_version_=(value: native.CString): Unit = !p._4 = value
      def query_string: native.CString = !p._5
      def query_string_=(value: native.CString): Unit = !p._5 = value
      def remote_user: native.CString = !p._6
      def remote_user_=(value: native.CString): Unit = !p._6 = value
      def remote_addr: native.Ptr[native.CArray[native.CChar, native.Nat.Digit[native.Nat._4, native.Nat._8]]] = p._7
      def remote_addr_=(value: native.Ptr[native.CArray[native.CChar, native.Nat.Digit[native.Nat._4, native.Nat._8]]]): Unit = !p._7 = !value
      def content_length: native.CLongLong = !p._8
      def content_length_=(value: native.CLongLong): Unit = !p._8 = value
      def remote_port: native.CInt = !p._9
      def remote_port_=(value: native.CInt): Unit = !p._9 = value
      def is_ssl: native.CInt = !p._10
      def is_ssl_=(value: native.CInt): Unit = !p._10 = value
      def user_data: native.Ptr[Byte] = !p._11
      def user_data_=(value: native.Ptr[Byte]): Unit = !p._11 = value
      def conn_data: native.Ptr[Byte] = !p._12
      def conn_data_=(value: native.Ptr[Byte]): Unit = !p._12 = value
      def num_headers: native.CInt = !p._13
      def num_headers_=(value: native.CInt): Unit = !p._13 = value
      def http_headers: native.Ptr[native.CArray[struct_mg_header, native.Nat.Digit[native.Nat._6, native.Nat._4]]] = p._14
      def http_headers_=(value: native.Ptr[native.CArray[struct_mg_header, native.Nat.Digit[native.Nat._6, native.Nat._4]]]): Unit = !p._14 = !value
      def client_cert: native.Ptr[struct_mg_client_cert] = !p._15
      def client_cert_=(value: native.Ptr[struct_mg_client_cert]): Unit = !p._15 = value
      def acceptedWebSocketSubprotocol: native.CString = !p._16
      def acceptedWebSocketSubprotocol_=(value: native.CString): Unit = !p._16 = value
    }

    implicit class struct_mg_response_info_ops(val p: native.Ptr[struct_mg_response_info]) extends AnyVal {
      def status_code: native.CInt = !p._1
      def status_code_=(value: native.CInt): Unit = !p._1 = value
      def status_text: native.CString = !p._2
      def status_text_=(value: native.CString): Unit = !p._2 = value
      def http_version: native.CString = !p._3
      def http_version_=(value: native.CString): Unit = !p._3 = value
      def content_length: native.CLongLong = !p._4
      def content_length_=(value: native.CLongLong): Unit = !p._4 = value
      def num_headers: native.CInt = !p._5
      def num_headers_=(value: native.CInt): Unit = !p._5 = value
      def http_headers: native.Ptr[native.CArray[struct_mg_header, native.Nat.Digit[native.Nat._6, native.Nat._4]]] = p._6
      def http_headers_=(value: native.Ptr[native.CArray[struct_mg_header, native.Nat.Digit[native.Nat._6, native.Nat._4]]]): Unit = !p._6 = !value
    }

    implicit class struct_mg_client_cert_ops(val p: native.Ptr[struct_mg_client_cert]) extends AnyVal {
      def peer_cert: native.Ptr[Byte] = !p._1
      def peer_cert_=(value: native.Ptr[Byte]): Unit = !p._1 = value
      def subject: native.CString = !p._2
      def subject_=(value: native.CString): Unit = !p._2 = value
      def issuer: native.CString = !p._3
      def issuer_=(value: native.CString): Unit = !p._3 = value
      def serial: native.CString = !p._4
      def serial_=(value: native.CString): Unit = !p._4 = value
      def finger: native.CString = !p._5
      def finger_=(value: native.CString): Unit = !p._5 = value
    }

    implicit class struct_mg_callbacks_ops(val p: native.Ptr[struct_mg_callbacks]) extends AnyVal {
      def begin_request: native.CFunctionPtr1[native.Ptr[struct_mg_connection], native.CInt] = !p._1
      def begin_request_=(value: native.CFunctionPtr1[native.Ptr[struct_mg_connection], native.CInt]): Unit = !p._1 = value
      def end_request: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.CInt, Unit] = !p._2
      def end_request_=(value: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.CInt, Unit]): Unit = !p._2 = value
      def log_message: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.CString, native.CInt] = !p._3
      def log_message_=(value: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.CString, native.CInt]): Unit = !p._3 = value
      def log_access: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.CString, native.CInt] = !p._4
      def log_access_=(value: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.CString, native.CInt]): Unit = !p._4 = value
      def init_ssl: native.CFunctionPtr2[native.Ptr[Byte], native.Ptr[Byte], native.CInt] = !p._5
      def init_ssl_=(value: native.CFunctionPtr2[native.Ptr[Byte], native.Ptr[Byte], native.CInt]): Unit = !p._5 = value
      def external_ssl_ctx: native.CFunctionPtr2[native.Ptr[native.Ptr[Byte]], native.Ptr[Byte], native.CInt] = !p._6
      def external_ssl_ctx_=(value: native.CFunctionPtr2[native.Ptr[native.Ptr[Byte]], native.Ptr[Byte], native.CInt]): Unit = !p._6 = value
      def connection_close: native.CFunctionPtr1[native.Ptr[struct_mg_connection], Unit] = !p._7
      def connection_close_=(value: native.CFunctionPtr1[native.Ptr[struct_mg_connection], Unit]): Unit = !p._7 = value
      def init_lua: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], Unit] = !p._8
      def init_lua_=(value: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], Unit]): Unit = !p._8 = value
      def http_error: native.CFunctionPtr3[native.Ptr[struct_mg_connection], native.CInt, native.CString, native.CInt] = !p._9
      def http_error_=(value: native.CFunctionPtr3[native.Ptr[struct_mg_connection], native.CInt, native.CString, native.CInt]): Unit = !p._9 = value
      def init_context: native.CFunctionPtr1[native.Ptr[struct_mg_context], Unit] = !p._10
      def init_context_=(value: native.CFunctionPtr1[native.Ptr[struct_mg_context], Unit]): Unit = !p._10 = value
      def init_thread: native.CFunctionPtr2[native.Ptr[struct_mg_context], native.CInt, Unit] = !p._11
      def init_thread_=(value: native.CFunctionPtr2[native.Ptr[struct_mg_context], native.CInt, Unit]): Unit = !p._11 = value
      def exit_context: native.CFunctionPtr1[native.Ptr[struct_mg_context], Unit] = !p._12
      def exit_context_=(value: native.CFunctionPtr1[native.Ptr[struct_mg_context], Unit]): Unit = !p._12 = value
      def init_connection: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[native.Ptr[Byte]], native.CInt] = !p._13
      def init_connection_=(value: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[native.Ptr[Byte]], native.CInt]): Unit = !p._13 = value
    }

    implicit class struct_mg_websocket_subprotocols_ops(val p: native.Ptr[struct_mg_websocket_subprotocols]) extends AnyVal {
      def nb_subprotocols: native.CInt = !p._1
      def nb_subprotocols_=(value: native.CInt): Unit = !p._1 = value
      def subprotocols: native.Ptr[native.CString] = !p._2
      def subprotocols_=(value: native.Ptr[native.CString]): Unit = !p._2 = value
    }

    implicit class struct_mg_option_ops(val p: native.Ptr[struct_mg_option]) extends AnyVal {
      def name: native.CString = !p._1
      def name_=(value: native.CString): Unit = !p._1 = value
      def `type`: native.CInt = !p._2
      def `type_=`(value: native.CInt): Unit = !p._2 = value
      def default_value: native.CString = !p._3
      def default_value_=(value: native.CString): Unit = !p._3 = value
    }

    implicit class struct_mg_server_ports_ops(val p: native.Ptr[struct_mg_server_ports]) extends AnyVal {
      def protocol: native.CInt = !p._1
      def protocol_=(value: native.CInt): Unit = !p._1 = value
      def port: native.CInt = !p._2
      def port_=(value: native.CInt): Unit = !p._2 = value
      def is_ssl: native.CInt = !p._3
      def is_ssl_=(value: native.CInt): Unit = !p._3 = value
      def is_redirect: native.CInt = !p._4
      def is_redirect_=(value: native.CInt): Unit = !p._4 = value
      def _reserved1: native.CInt = !p._5
      def _reserved1_=(value: native.CInt): Unit = !p._5 = value
      def _reserved2: native.CInt = !p._6
      def _reserved2_=(value: native.CInt): Unit = !p._6 = value
      def _reserved3: native.CInt = !p._7
      def _reserved3_=(value: native.CInt): Unit = !p._7 = value
      def _reserved4: native.CInt = !p._8
      def _reserved4_=(value: native.CInt): Unit = !p._8 = value
    }

    implicit class struct_mg_form_data_handler_ops(val p: native.Ptr[struct_mg_form_data_handler]) extends AnyVal {
      def field_found: native.CFunctionPtr5[native.CString, native.CString, native.CString, native.CSize, native.Ptr[Byte], native.CInt] = !p._1
      def field_found_=(value: native.CFunctionPtr5[native.CString, native.CString, native.CString, native.CSize, native.Ptr[Byte], native.CInt]): Unit = !p._1 = value
      def field_get: native.CFunctionPtr4[native.CString, native.CString, native.CSize, native.Ptr[Byte], native.CInt] = !p._2
      def field_get_=(value: native.CFunctionPtr4[native.CString, native.CString, native.CSize, native.Ptr[Byte], native.CInt]): Unit = !p._2 = value
      def field_store: native.CFunctionPtr3[native.CString, native.CLongLong, native.Ptr[Byte], native.CInt] = !p._3
      def field_store_=(value: native.CFunctionPtr3[native.CString, native.CLongLong, native.Ptr[Byte], native.CInt]): Unit = !p._3 = value
      def user_data: native.Ptr[Byte] = !p._4
      def user_data_=(value: native.Ptr[Byte]): Unit = !p._4 = value
    }

    implicit class struct_mg_client_options_ops(val p: native.Ptr[struct_mg_client_options]) extends AnyVal {
      def host: native.CString = !p._1
      def host_=(value: native.CString): Unit = !p._1 = value
      def port: native.CInt = !p._2
      def port_=(value: native.CInt): Unit = !p._2 = value
      def client_cert: native.CString = !p._3
      def client_cert_=(value: native.CString): Unit = !p._3 = value
      def server_cert: native.CString = !p._4
      def server_cert_=(value: native.CString): Unit = !p._4 = value
    }
  }

  object struct_mg_header {
    import implicits._
    def apply()(implicit z: native.Zone): native.Ptr[struct_mg_header] = native.alloc[struct_mg_header]
    def apply(name: native.CString, value: native.CString)(implicit z: native.Zone): native.Ptr[struct_mg_header] = {
      val ptr = native.alloc[struct_mg_header]
      ptr.name = name
      ptr.value = value
      ptr
    }
  }

  object struct_mg_request_info {
    import implicits._
    def apply()(implicit z: native.Zone): native.Ptr[struct_mg_request_info] = native.alloc[struct_mg_request_info]
    def apply(request_method: native.CString, request_uri: native.CString, local_uri: native.CString, http_version: native.CString, query_string: native.CString, remote_user: native.CString, remote_addr: native.Ptr[native.CArray[native.CChar, native.Nat.Digit[native.Nat._4, native.Nat._8]]], content_length: native.CLongLong, remote_port: native.CInt, is_ssl: native.CInt, user_data: native.Ptr[Byte], conn_data: native.Ptr[Byte], num_headers: native.CInt, http_headers: native.Ptr[native.CArray[struct_mg_header, native.Nat.Digit[native.Nat._6, native.Nat._4]]], client_cert: native.Ptr[struct_mg_client_cert], acceptedWebSocketSubprotocol: native.CString)(implicit z: native.Zone): native.Ptr[struct_mg_request_info] = {
      val ptr = native.alloc[struct_mg_request_info]
      ptr.request_method = request_method
      ptr.request_uri = request_uri
      ptr.local_uri = local_uri
      ptr.http_version = http_version
      ptr.query_string = query_string
      ptr.remote_user = remote_user
      ptr.remote_addr = remote_addr
      ptr.content_length = content_length
      ptr.remote_port = remote_port
      ptr.is_ssl = is_ssl
      ptr.user_data = user_data
      ptr.conn_data = conn_data
      ptr.num_headers = num_headers
      ptr.http_headers = http_headers
      ptr.client_cert = client_cert
      ptr.acceptedWebSocketSubprotocol = acceptedWebSocketSubprotocol
      ptr
    }
  }

  object struct_mg_response_info {
    import implicits._
    def apply()(implicit z: native.Zone): native.Ptr[struct_mg_response_info] = native.alloc[struct_mg_response_info]
    def apply(status_code: native.CInt, status_text: native.CString, http_version: native.CString, content_length: native.CLongLong, num_headers: native.CInt, http_headers: native.Ptr[native.CArray[struct_mg_header, native.Nat.Digit[native.Nat._6, native.Nat._4]]])(implicit z: native.Zone): native.Ptr[struct_mg_response_info] = {
      val ptr = native.alloc[struct_mg_response_info]
      ptr.status_code = status_code
      ptr.status_text = status_text
      ptr.http_version = http_version
      ptr.content_length = content_length
      ptr.num_headers = num_headers
      ptr.http_headers = http_headers
      ptr
    }
  }

  object struct_mg_client_cert {
    import implicits._
    def apply()(implicit z: native.Zone): native.Ptr[struct_mg_client_cert] = native.alloc[struct_mg_client_cert]
    def apply(peer_cert: native.Ptr[Byte], subject: native.CString, issuer: native.CString, serial: native.CString, finger: native.CString)(implicit z: native.Zone): native.Ptr[struct_mg_client_cert] = {
      val ptr = native.alloc[struct_mg_client_cert]
      ptr.peer_cert = peer_cert
      ptr.subject = subject
      ptr.issuer = issuer
      ptr.serial = serial
      ptr.finger = finger
      ptr
    }
  }

  object struct_mg_callbacks {
    import implicits._
    def apply()(implicit z: native.Zone): native.Ptr[struct_mg_callbacks] = native.alloc[struct_mg_callbacks]
    def apply(begin_request: native.CFunctionPtr1[native.Ptr[struct_mg_connection], native.CInt], end_request: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.CInt, Unit], log_message: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.CString, native.CInt], log_access: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.CString, native.CInt], init_ssl: native.CFunctionPtr2[native.Ptr[Byte], native.Ptr[Byte], native.CInt], external_ssl_ctx: native.CFunctionPtr2[native.Ptr[native.Ptr[Byte]], native.Ptr[Byte], native.CInt], connection_close: native.CFunctionPtr1[native.Ptr[struct_mg_connection], Unit], init_lua: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[Byte], Unit], http_error: native.CFunctionPtr3[native.Ptr[struct_mg_connection], native.CInt, native.CString, native.CInt], init_context: native.CFunctionPtr1[native.Ptr[struct_mg_context], Unit], init_thread: native.CFunctionPtr2[native.Ptr[struct_mg_context], native.CInt, Unit], exit_context: native.CFunctionPtr1[native.Ptr[struct_mg_context], Unit], init_connection: native.CFunctionPtr2[native.Ptr[struct_mg_connection], native.Ptr[native.Ptr[Byte]], native.CInt])(implicit z: native.Zone): native.Ptr[struct_mg_callbacks] = {
      val ptr = native.alloc[struct_mg_callbacks]
      ptr.begin_request = begin_request
      ptr.end_request = end_request
      ptr.log_message = log_message
      ptr.log_access = log_access
      ptr.init_ssl = init_ssl
      ptr.external_ssl_ctx = external_ssl_ctx
      ptr.connection_close = connection_close
      ptr.init_lua = init_lua
      ptr.http_error = http_error
      ptr.init_context = init_context
      ptr.init_thread = init_thread
      ptr.exit_context = exit_context
      ptr.init_connection = init_connection
      ptr
    }
  }

  object struct_mg_websocket_subprotocols {
    import implicits._
    def apply()(implicit z: native.Zone): native.Ptr[struct_mg_websocket_subprotocols] = native.alloc[struct_mg_websocket_subprotocols]
    def apply(nb_subprotocols: native.CInt, subprotocols: native.Ptr[native.CString])(implicit z: native.Zone): native.Ptr[struct_mg_websocket_subprotocols] = {
      val ptr = native.alloc[struct_mg_websocket_subprotocols]
      ptr.nb_subprotocols = nb_subprotocols
      ptr.subprotocols = subprotocols
      ptr
    }
  }

  object struct_mg_option {
    import implicits._
    def apply()(implicit z: native.Zone): native.Ptr[struct_mg_option] = native.alloc[struct_mg_option]
    def apply(name: native.CString, `type`: native.CInt, default_value: native.CString)(implicit z: native.Zone): native.Ptr[struct_mg_option] = {
      val ptr = native.alloc[struct_mg_option]
      ptr.name = name
      ptr.`type` = `type`
      ptr.default_value = default_value
      ptr
    }
  }

  object struct_mg_server_ports {
    import implicits._
    def apply()(implicit z: native.Zone): native.Ptr[struct_mg_server_ports] = native.alloc[struct_mg_server_ports]
    def apply(protocol: native.CInt, port: native.CInt, is_ssl: native.CInt, is_redirect: native.CInt, _reserved1: native.CInt, _reserved2: native.CInt, _reserved3: native.CInt, _reserved4: native.CInt)(implicit z: native.Zone): native.Ptr[struct_mg_server_ports] = {
      val ptr = native.alloc[struct_mg_server_ports]
      ptr.protocol = protocol
      ptr.port = port
      ptr.is_ssl = is_ssl
      ptr.is_redirect = is_redirect
      ptr._reserved1 = _reserved1
      ptr._reserved2 = _reserved2
      ptr._reserved3 = _reserved3
      ptr._reserved4 = _reserved4
      ptr
    }
  }

  object struct_mg_form_data_handler {
    import implicits._
    def apply()(implicit z: native.Zone): native.Ptr[struct_mg_form_data_handler] = native.alloc[struct_mg_form_data_handler]
    def apply(field_found: native.CFunctionPtr5[native.CString, native.CString, native.CString, native.CSize, native.Ptr[Byte], native.CInt], field_get: native.CFunctionPtr4[native.CString, native.CString, native.CSize, native.Ptr[Byte], native.CInt], field_store: native.CFunctionPtr3[native.CString, native.CLongLong, native.Ptr[Byte], native.CInt], user_data: native.Ptr[Byte])(implicit z: native.Zone): native.Ptr[struct_mg_form_data_handler] = {
      val ptr = native.alloc[struct_mg_form_data_handler]
      ptr.field_found = field_found
      ptr.field_get = field_get
      ptr.field_store = field_store
      ptr.user_data = user_data
      ptr
    }
  }

  object struct_mg_client_options {
    import implicits._
    def apply()(implicit z: native.Zone): native.Ptr[struct_mg_client_options] = native.alloc[struct_mg_client_options]
    def apply(host: native.CString, port: native.CInt, client_cert: native.CString, server_cert: native.CString)(implicit z: native.Zone): native.Ptr[struct_mg_client_options] = {
      val ptr = native.alloc[struct_mg_client_options]
      ptr.host = host
      ptr.port = port
      ptr.client_cert = client_cert
      ptr.server_cert = server_cert
      ptr
    }
  }
}

