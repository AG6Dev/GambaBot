package dev.ag6.gambabot.core.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Marking a class with this annotation allows the {@link CommandManager} to automatically register the type as a command.
 * The class must extend {@link Command} and have a public no-arg constructor.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AutoRegisterCommand {
}
