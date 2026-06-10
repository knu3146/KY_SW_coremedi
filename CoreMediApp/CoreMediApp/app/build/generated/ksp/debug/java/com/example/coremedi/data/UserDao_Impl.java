package com.example.coremedi.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserEntity> __insertionAdapterOfUserEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateHealthInfo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateProfile;

  public UserDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserEntity = new EntityInsertionAdapter<UserEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `users` (`id`,`username`,`displayName`,`passwordHash`,`passwordSalt`,`age`,`gender`,`allergyText`,`sideEffectText`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getUsername());
        statement.bindString(3, entity.getDisplayName());
        statement.bindString(4, entity.getPasswordHash());
        statement.bindString(5, entity.getPasswordSalt());
        statement.bindString(6, entity.getAge());
        statement.bindString(7, entity.getGender());
        statement.bindString(8, entity.getAllergyText());
        statement.bindString(9, entity.getSideEffectText());
      }
    };
    this.__preparedStmtOfUpdateHealthInfo = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET allergyText = ?, sideEffectText = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateProfile = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET age = ?, gender = ?, allergyText = ?, sideEffectText = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final UserEntity user, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfUserEntity.insertAndReturnId(user);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateHealthInfo(final long id, final String allergyText,
      final String sideEffectText, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateHealthInfo.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, allergyText);
        _argIndex = 2;
        _stmt.bindString(_argIndex, sideEffectText);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateHealthInfo.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateProfile(final long id, final String age, final String gender,
      final String allergyText, final String sideEffectText,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateProfile.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, age);
        _argIndex = 2;
        _stmt.bindString(_argIndex, gender);
        _argIndex = 3;
        _stmt.bindString(_argIndex, allergyText);
        _argIndex = 4;
        _stmt.bindString(_argIndex, sideEffectText);
        _argIndex = 5;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateProfile.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object findByUsername(final String username,
      final Continuation<? super UserEntity> $completion) {
    final String _sql = "SELECT * FROM users WHERE username = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, username);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserEntity>() {
      @Override
      @Nullable
      public UserEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
          final int _cursorIndexOfPasswordHash = CursorUtil.getColumnIndexOrThrow(_cursor, "passwordHash");
          final int _cursorIndexOfPasswordSalt = CursorUtil.getColumnIndexOrThrow(_cursor, "passwordSalt");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfAllergyText = CursorUtil.getColumnIndexOrThrow(_cursor, "allergyText");
          final int _cursorIndexOfSideEffectText = CursorUtil.getColumnIndexOrThrow(_cursor, "sideEffectText");
          final UserEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpUsername;
            _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            final String _tmpDisplayName;
            _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            final String _tmpPasswordHash;
            _tmpPasswordHash = _cursor.getString(_cursorIndexOfPasswordHash);
            final String _tmpPasswordSalt;
            _tmpPasswordSalt = _cursor.getString(_cursorIndexOfPasswordSalt);
            final String _tmpAge;
            _tmpAge = _cursor.getString(_cursorIndexOfAge);
            final String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            final String _tmpAllergyText;
            _tmpAllergyText = _cursor.getString(_cursorIndexOfAllergyText);
            final String _tmpSideEffectText;
            _tmpSideEffectText = _cursor.getString(_cursorIndexOfSideEffectText);
            _result = new UserEntity(_tmpId,_tmpUsername,_tmpDisplayName,_tmpPasswordHash,_tmpPasswordSalt,_tmpAge,_tmpGender,_tmpAllergyText,_tmpSideEffectText);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object findById(final long id, final Continuation<? super UserEntity> $completion) {
    final String _sql = "SELECT * FROM users WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserEntity>() {
      @Override
      @Nullable
      public UserEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
          final int _cursorIndexOfPasswordHash = CursorUtil.getColumnIndexOrThrow(_cursor, "passwordHash");
          final int _cursorIndexOfPasswordSalt = CursorUtil.getColumnIndexOrThrow(_cursor, "passwordSalt");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfAllergyText = CursorUtil.getColumnIndexOrThrow(_cursor, "allergyText");
          final int _cursorIndexOfSideEffectText = CursorUtil.getColumnIndexOrThrow(_cursor, "sideEffectText");
          final UserEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpUsername;
            _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            final String _tmpDisplayName;
            _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            final String _tmpPasswordHash;
            _tmpPasswordHash = _cursor.getString(_cursorIndexOfPasswordHash);
            final String _tmpPasswordSalt;
            _tmpPasswordSalt = _cursor.getString(_cursorIndexOfPasswordSalt);
            final String _tmpAge;
            _tmpAge = _cursor.getString(_cursorIndexOfAge);
            final String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            final String _tmpAllergyText;
            _tmpAllergyText = _cursor.getString(_cursorIndexOfAllergyText);
            final String _tmpSideEffectText;
            _tmpSideEffectText = _cursor.getString(_cursorIndexOfSideEffectText);
            _result = new UserEntity(_tmpId,_tmpUsername,_tmpDisplayName,_tmpPasswordHash,_tmpPasswordSalt,_tmpAge,_tmpGender,_tmpAllergyText,_tmpSideEffectText);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
