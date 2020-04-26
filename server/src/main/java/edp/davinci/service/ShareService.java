/*
 * <<
 *  Davinci
 *  ==
 *  Copyright (C) 2016 - 2019 EDP
 *  ==
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  >>
 *
 */

package edp.davinci.service;

import edp.core.exception.ForbiddenExecption;
import edp.core.exception.NotFoundException;
import edp.core.exception.ServerException;
import edp.core.exception.UnAuthorizedExecption;
import edp.core.model.Paginate;
import edp.davinci.dto.shareDto.*;
import edp.davinci.dto.userDto.UserLogin;
import edp.davinci.dto.viewDto.DistinctParam;
import edp.davinci.dto.viewDto.ViewExecuteParam;
import edp.davinci.model.User;
import edp.davinci.service.share.ShareWidget;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ShareService {
    ShareWidget getShareWidget(User user) throws NotFoundException, ServerException, ForbiddenExecption, UnAuthorizedExecption;

    String generateShareToken(Long shareEntityId, String username, Long userId) throws ServerException;

    User shareLogin(UserLogin userLogin) throws NotFoundException, ServerException, UnAuthorizedExecption;

    ShareDisplay getShareDisplay(User user) throws NotFoundException, ServerException, ForbiddenExecption, UnAuthorizedExecption;

    ShareDashboard getShareDashboard(User user) throws NotFoundException, ServerException, ForbiddenExecption, UnAuthorizedExecption;

    Paginate<Map<String, Object>> getShareData(ViewExecuteParam executeParam, User user) throws NotFoundException, ServerException, ForbiddenExecption, UnAuthorizedExecption, SQLException;

    List<Map<String, Object>> getDistinctValue(Long viewId, DistinctParam param, User user);

    void formatShareParam(Long projectId, ShareEntity entity);

    Map<String, Object> checkShareToken() throws ServerException, ForbiddenExecption;

    Map<String, Object> getSharePermissions() throws ServerException, ForbiddenExecption;

    @Deprecated
    ShareInfo getShareInfo(String token, User user) throws ServerException, ForbiddenExecption;

    @Deprecated
    void verifyShareUser(User user, ShareInfo shareInfo) throws ServerException, ForbiddenExecption;
}
