/*
* Copyright 2014 Red Hat, Inc.
*
* Red Hat licenses this file to you under the Apache License, version 2.0
* (the "License"); you may not use this file except in compliance with the
* License. You may obtain a copy of the License at:
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
* WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
* License for the specific language governing permissions and limitations
* under the License.
*/

package name.bpdp.vertx.blazegraph;

import name.bpdp.vertx.blazegraph.BlazegraphService;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.Vertx;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import io.vertx.serviceproxy.ProxyHelper;
import name.bpdp.vertx.blazegraph.BlazegraphService;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

/*
  Generated Proxy code - DO NOT EDIT
  @author Roger the Robot
*/
public class BlazegraphServiceVertxEBProxy implements BlazegraphService {

  private Vertx _vertx;
  private String _address;
  private boolean closed;

  public BlazegraphServiceVertxEBProxy(Vertx vertx, String address) {
    this._vertx = vertx;
    this._address = address;
  }

  public void save(String collection) {
    if (closed) {
      throw new IllegalStateException("Proxy is closed");
    }
    JsonObject _json = new JsonObject();
    _json.put("collection", collection);
    DeliveryOptions _deliveryOptions = new DeliveryOptions();
    _deliveryOptions.addHeader("action", "save");
    _vertx.eventBus().send(_address, _json, _deliveryOptions);
  }


  private List<Character> convertToListChar(JsonArray arr) {
    List<Character> list = new ArrayList<>();
    for (Object obj: arr) {
      Integer jobj = (Integer)obj;
      list.add((char)jobj.intValue());
    }
    return list;
  }

  private Set<Character> convertToSetChar(JsonArray arr) {
    Set<Character> set = new HashSet<>();
    for (Object obj: arr) {
      Integer jobj = (Integer)obj;
      set.add((char)jobj.intValue());
    }
    return set;
  }

  private <T> Map<String, T> convertMap(Map map) {
    return (Map<String, T>)map;
  }
  private <T> List<T> convertList(List list) {
    return (List<T>)list;
  }
  private <T> Set<T> convertSet(List list) {
    return new HashSet<T>((List<T>)list);
  }
}