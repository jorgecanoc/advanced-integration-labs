/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jboss.fuse.security.cxf.service;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * This interface describes a JAX-RS root resource. All the JAXRS annotations (except those overridden) will
 * be inherited by classes implementing it.
 */
@Path("/customerservice/")
public interface CustomerService {

    @GET
    @Path("/customers/{id}/")
    @RolesAllowed({"ADMIN","USER"})
    Customer getCustomer(@PathParam("id") String id);
    
    @PUT
    @Path("/customers/")
    Response updateCustomer(Customer customer);
     
    @POST
    @Path("/customers/")
    @RolesAllowed({"ADMIN"})
    Response addCustomer(Customer customer);

    @DELETE
    @Path("/customers/{id}/")
    Response deleteCustomer(@PathParam("id") String id);

}
