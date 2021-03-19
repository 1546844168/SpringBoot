package com.jf.utils.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.jf.common.constant.TimeStyleConstant;

/**
 * 描述: 时间操作相关工具类
 *
 * @author: 江峰
 * @create: 2021-03-19 17:32
 * @since: 2.20.1.1
 */

public class LocalDateTimeUtil {

	public static void main(String[] args) {

		System.out.println(formatLocalDateTime(LocalDateTime.now(),
				TimeStyleConstant.FORMAT_YYYYMMDD24HHMMSS));

		System.out.println(parseStrToLocalDate("2021-03-19",
				TimeStyleConstant.FORMAT_YYMMDD));

	}

	/**
	 * 对LocalDateTime 格式化格式化为字符串
	 *
	 *
	 * @param localDateTime
	 * @param formatStyle
	 * @return
	 */
	public static String formatLocalDateTime(LocalDateTime localDateTime,
			String formatStyle) {
		Objects.requireNonNull(localDateTime, "localDateTime");
		Objects.requireNonNull(formatStyle, "formatStyle");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStyle);
		return localDateTime.format(formatter);
	}

	/**
	 * timeStr => "2021-03-19 17:56:36" 将字符串时间转换为LocalDateTime
	 *
	 * @param timeStr
	 * @param formatStyle
	 * @return
	 */
	public static LocalDateTime parseStrToLocalDateTime(String timeStr,
			String formatStyle) {
		Objects.requireNonNull(timeStr, "timeStr");
		Objects.requireNonNull(formatStyle, "formatStyle");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStyle);
		return LocalDateTime.parse(timeStr, formatter);
	}

	/**
	 * timeStr => "2021-03-19" 将字符串时间转换为LocalDate
	 *
	 * @param timeStr
	 * @param formatStyle
	 * @return
	 */
	public static LocalDate parseStrToLocalDate(String timeStr,
			String formatStyle) {
		Objects.requireNonNull(timeStr, "timeStr");
		Objects.requireNonNull(formatStyle, "formatStyle");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStyle);
		return LocalDate.parse(timeStr, formatter);
	}

	/**
	 * 获取系统当前日期时间
	 * 
	 * @return
	 */
	public static LocalDateTime systemLocalDateTime() {
		return LocalDateTime.now();
	}

	/**
	 * localDataTime 转换为 localData
	 * 
	 * @param localDateTime
	 * @return
	 */
	public static LocalDate toLocalDate(LocalDateTime localDateTime) {
		return localDateTime.toLocalDate();
	}

	/**
	 * localDataTime 转换为 localTime
	 * 
	 * @param localDateTime
	 * @return
	 */
	public static LocalTime toLocalTime(LocalDateTime localDateTime) {
		return localDateTime.toLocalTime();
	}

}