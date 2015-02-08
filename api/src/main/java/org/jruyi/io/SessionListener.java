/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jruyi.io;

/**
 * A default {@code ISessionListener} implementation with all methods doing
 * nothing.
 */
public class SessionListener implements ISessionListener {

	/**
	 * Empty implementation.
	 */
	@Override
	public void onSessionOpened(ISession session) {
	}

	/**
	 * Empty implementation.
	 */
	@Override
	public void onSessionClosed(ISession session) {
	}

	/**
	 * Empty implementation.
	 */
	@Override
	public void onMessageSent(ISession session, Object msg) {
	}

	/**
	 * Empty implementation.
	 */
	@Override
	public void onMessageReceived(ISession session, Object msg) {
	}

	/**
	 * Empty implementation.
	 */
	@Override
	public void onSessionException(ISession session, Throwable t) {
	}

	/**
	 * Empty implementation.
	 */
	@Override
	public void onSessionIdleTimedOut(ISession session) {
	}

	/**
	 * Empty implementation.
	 */
	@Override
	public void onSessionConnectTimedOut(ISession session) {
	}

	/**
	 * Empty implementation.
	 */
	@Override
	public void onSessionReadTimedOut(ISession session) {
	}
}
