/*
 * Copyright (C) 2017 Moez Bhatti <moez.bhatti@gmail.com>
 *
 * This file is part of QKSMS.
 *
 * QKSMS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * QKSMS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with QKSMS.  If not, see <http://www.gnu.org/licenses/>.
 */
package interactor

import common.util.NotificationManager
import data.repository.MessageRepository
import io.reactivex.Flowable
import javax.inject.Inject

class MarkRead @Inject constructor(
        private val messageRepo: MessageRepository,
        private val notificationManager: NotificationManager
) : Interactor<Long, Unit>() {

    override fun buildObservable(params: Long): Flowable<Unit> {
        return Flowable.just(Unit)
                .doOnNext { messageRepo.markRead(params) }
                .doOnNext { notificationManager.update(params) }
    }

}