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

package org.jruyi.io.channel;

import org.jruyi.common.ICloseable;
import org.jruyi.common.IThreadLocalCache;
import org.jruyi.common.ThreadLocalCache;
import org.jruyi.io.IFilter;

final class IoEvent implements ICloseable {

	private static final IThreadLocalCache<IoEvent> c_cache = ThreadLocalCache.weakLinkedCache();

	private Runnable m_command;
	private IIoTask m_task;
	private Object m_msg;
	private IFilter<?, ?>[] m_filters;
	private int m_filterCount;

	public static IoEvent create() {
		IoEvent event = c_cache.take();
		if (event == null)
			event = new IoEvent();
		return event;
	}

	@Override
	public void close() {
		c_cache.put(this);
	}

	public IoEvent command(Runnable command) {
		m_command = command;
		return this;
	}

	public Runnable command() {
		final Runnable command = m_command;
		m_command = null;
		return command;
	}

	public IoEvent task(IIoTask task) {
		m_task = task;
		return this;
	}

	public IIoTask task() {
		final IIoTask task = m_task;
		m_task = null;
		return task;
	}

	public IoEvent msg(Object msg) {
		m_msg = msg;
		return this;
	}

	public Object msg() {
		final Object msg = m_msg;
		m_msg = null;
		return msg;
	}

	public IoEvent filters(IFilter<?, ?>[] filters) {
		m_filters = filters;
		return this;
	}

	public IFilter<?, ?>[] filters() {
		final IFilter<?, ?>[] filters = m_filters;
		m_filters = null;
		return filters;
	}

	public IoEvent filterCount(int filterCount) {
		m_filterCount = filterCount;
		return this;
	}

	public int filterCount() {
		return m_filterCount;
	}
}
