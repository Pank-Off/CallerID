package com.technopark.callerid.model.room;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import io.reactivex.Single;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SpamerDao_Impl implements SpamerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Spamer> __insertionAdapterOfSpamer;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public SpamerDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSpamer = new EntityInsertionAdapter<Spamer>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `table_spamers` (`id`,`phoneNumber`,`isSpam`,`comment`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Spamer value) {
        stmt.bindLong(1, value.getId());
        if (value.getPhoneNumber() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPhoneNumber());
        }
        final int _tmp;
        _tmp = value.isSpam() ? 1 : 0;
        stmt.bindLong(3, _tmp);
        if (value.getComment() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getComment());
        }
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM table_spamers WHERE phoneNumber = ?";
        return _query;
      }
    };
  }

  @Override
  public Single<Long> insert(final Spamer spamer) {
    return Single.fromCallable(new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfSpamer.insertAndReturnId(spamer);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Single<Integer> delete(final String phoneNumber) {
    return Single.fromCallable(new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
        int _argIndex = 1;
        if (phoneNumber == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, phoneNumber);
        }
        __db.beginTransaction();
        try {
          final java.lang.Integer _result = _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDelete.release(_stmt);
        }
      }
    });
  }

  @Override
  public Single<List<Spamer>> getAll() {
    final String _sql = "SELECT * FROM table_spamers";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createSingle(new Callable<List<Spamer>>() {
      @Override
      public List<Spamer> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfIsSpam = CursorUtil.getColumnIndexOrThrow(_cursor, "isSpam");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final List<Spamer> _result = new ArrayList<Spamer>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Spamer _item;
            final String _tmpPhoneNumber;
            _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            final boolean _tmpIsSpam;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSpam);
            _tmpIsSpam = _tmp != 0;
            final String _tmpComment;
            _tmpComment = _cursor.getString(_cursorIndexOfComment);
            _item = new Spamer(_tmpPhoneNumber,_tmpIsSpam,_tmpComment);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Cursor getSingleUserInfo(final String phoneNumber) {
    final String _sql = "SELECT * FROM table_spamers WHERE phoneNumber = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (phoneNumber == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, phoneNumber);
    }
    final Cursor _tmpResult = __db.query(_statement);
    return _tmpResult;
  }
}
